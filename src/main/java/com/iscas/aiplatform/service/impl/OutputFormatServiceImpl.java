package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.OutPutFormat;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.mapper.OutputFormatMapper;
import com.iscas.aiplatform.service.OutputFormatService;
import com.iscas.aiplatform.service.SampleService;
import com.iscas.aiplatform.utils.AddNoUtil;
import com.iscas.aiplatform.utils.JSONFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/5/12 14:53
 * @Version 1.0
 * @Description:
 */
@Service
public class OutputFormatServiceImpl implements OutputFormatService {

    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private OutputFormatMapper outputFormatMapper;

    @Autowired
    private SampleService sampleService;
    @Override
    public String shareSample(int id) {
        Result result = new Result();
        if(outputFormatMapper.shareSampleStatus(id) == 1){
            result.setSuccess(true);
            result.setMsg("共享成功");
        }
        else {
            result.setSuccess(false);
            result.setMsg("共享失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String cancelShareSample(int id) {
        Result result = new Result();
        if(outputFormatMapper.cancelShareSampleStatus(id) == 1){
            result.setSuccess(true);
            result.setMsg("取消共享成功");
        }
        else {
            result.setSuccess(false);
            result.setMsg("取消共享失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public String addOutputFormat(String path, String describe, String username, String faultSet,String start) {
        String[] faultSets = faultSet.split(",");
        for (String s:faultSets){
            OutPutFormat outputFormat=new OutPutFormat(username, path, describe, s);
            outputFormatMapper.writeToOutputFormat(outputFormat);
            System.out.println("插入之后返回的id是"+outputFormat.getId());
            if ("true".equals(start)){
                System.out.println("启动样本制造");
                sampleService.createSample(outputFormat.getId());
            }
        }
        Result result= new Result("上传输出格式数据成功",true,"成功导入"+faultSets.length+"条数据");
        logger.info(result.toString());
        return JSON.toJSONString(result);
    }

    @Override
    public String showSampleByName(String username) {
        List<Map<String,Object>> list=outputFormatMapper.showSampleByName(username);
        Result result= new Result("访问成功",true,AddNoUtil.addNo(list));
        return JSON.toJSONString(result, JSONFilter.filter);
    }

    @Override
    public String showSharedSample() {
        List<Map<String,Object>> list = outputFormatMapper.showSharedSample();
        Result result = new Result("访问成功",true, AddNoUtil.addNo(list));
        return JSON.toJSONString(result, JSONFilter.filter);
    }

    @Override
    public String getFaultSet() {
        List<Map<String,Object>> list = outputFormatMapper.selectFaultSet();
        Result result = new Result("访问故障集成功",true,list);
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteOutputFormat(int id) {
        Result result = new Result();
        if(outputFormatMapper.deleteOutputFormat(id) == 1){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }
        else {
            result.setSuccess(false);
            result.setMsg("删除失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public List<Map<String,Object>> listOutputFormatDes(String username) {
        return outputFormatMapper.listOutputFormatDes(username);
    }

}
