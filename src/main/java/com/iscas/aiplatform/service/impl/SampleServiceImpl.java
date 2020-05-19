package com.iscas.aiplatform.service.impl;

import com.iscas.aiplatform.conf.SampleConfig;
import com.iscas.aiplatform.mapper.SampleMapper;
import com.iscas.aiplatform.service.SampleService;
import com.iscas.aiplatform.utils.FileClient;
import com.iscas.aiplatform.utils.STClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lvxianjin
 * @Date: 2020/5/11 09:06
 * @Description:
 */
@Service
public class SampleServiceImpl implements SampleService {
    private Map<Integer, SampleThread> threadMap = new HashMap<>();
    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public void createSample(int id) {
        SampleThread thread = new SampleThread(id);
        thread.start();
        threadMap.put(id, thread);
    }

    @Override
    public void stopSample(int id) {
        threadMap.get(id).status = false;
    }

    public class SampleThread extends Thread {
        //volatile修饰符用来保证其它线程读取的总是该变量的最新的值
        public volatile boolean status = true;
        private int id;

        public SampleThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            FileClient fileClient = new FileClient();
            STClient stClient = new STClient();
            Map<String, String> info = sampleMapper.getSampleInfo(id);
            System.out.println("将要制造的数据"+info);
            String userName = info.get("username");
            String fault_set = info.get("fault_set");
            String output_format_path = info.get("output_format_path");
            String output_format_no = output_format_path.split("/")[3];
            //读取LS文件中的摘要信息
            while (status) {
                List<String> pathList = fileClient.getContent(SampleConfig.rootPath + "/result_index.txt", "utf-8");
                int fault_NO = Integer.parseInt(fault_set);
                for (int i = pathList.size()-1; i >= 0; i--) {
                    String res = SampleConfig.resultPath + pathList.get(i) + "/" + userName + "/" + fault_set+"/"+output_format_no;
                    File file = new File(res);
                    if (!file.exists()) {
                        List<String> errorList = fileClient.getPath(SampleConfig.rootPath + pathList.get(i), "S11");
                        /**
                         * 1.依次读取故障集，转换成st.s11文件
                         * （1）故障集从0开始编码
                         * 2.带入输出结果格式
                         * 3.启动仿真计算
                         * 4.读取仿真结果，写入结果目录
                         **/
                        //依次读取故障集的内容
                        List<String> error = fileClient.getContent(SampleConfig.rootPath + pathList.get(i) + "/" + errorList.get(fault_NO-1), "utf-8");
                        //将故障内容写入
                        fileClient.writeResult(error, SampleConfig.rootPath + pathList.get(i) + "/ST.S11", "utf-8");
                        //将输出格式写入
                        List<String> out_format = fileClient.getContent(output_format_path, "utf-8");
                        fileClient.writeResult(out_format, SampleConfig.rootPath + pathList.get(i) + "/ST.SME", "utf-8");
                        //启动仿真计算
                        boolean isOK = stClient.startST(SampleConfig.rootPath + pathList.get(i));
                        //读取结果，将故障集与仿真结果保存在结果目录
                        if (isOK) {
                            file.mkdirs();
                            //将故障集带入结果目录下
                            fileClient.writeResult(error, res + "/ST.S11", "utf-8");
                            //将仿真结果文件带入结果目录下
                            List<String> result_str = fileClient.getContent(SampleConfig.rootPath + pathList.get(i) + "/" + "STERR.LIS", "utf-8");
                            fileClient.writeResult(result_str, res + "/STERR.LIS", "utf-8");
                            sampleMapper.addSample(res + "/STERR.LIS", id);
                        }
                    }
                    try {
                        Thread.sleep(180000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
