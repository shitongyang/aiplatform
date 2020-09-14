package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.mapper.TrainInstanceMapper;
import com.iscas.aiplatform.service.TrainInstanceService;
import com.iscas.aiplatform.utils.AddNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author yangShiTong
 * @Date 2020/9/14 11:34
 * @Version 1.0
 * @Description:
 */
@Service
public class TrainInstanceServiceImpl implements TrainInstanceService {

    @Autowired
    private TrainInstanceMapper trainInstanceMapper;

    @Override
    public List<Map<String, Object>> listInstances(String username) {
        List resultList=trainInstanceMapper.listInstances(username);
        return AddNoUtil.addNo(resultList);
    }

    @Override
    public String insertTrainInstance(TrainInstance trainInstance) {
        Result result = new Result();
        if(trainInstanceMapper.insertTrainInstance(trainInstance) == 1){
            result.setSuccess(true);
            result.setMsg("创建实例成功");
        }else {
            result.setSuccess(false);
            result.setMsg("创建实例失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String startTrainInstance() {
        //获取上传的执行脚本和训练程序
        String shell = null;
        try {
            Runtime.getRuntime().exec(shell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String terminateTrainInstance() {
        return null;
    }
}
