package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.mapper.OutputFormatMapper;
import com.iscas.aiplatform.service.OutputFormatService;
import com.iscas.aiplatform.utils.JSONFilter;
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

    @Autowired
    private OutputFormatMapper outputFormatMapper;
    @Override
    public String shareSample(int id) {
        Result result=new Result();
        if(outputFormatMapper.shareSampleStatus(id)==1){
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
        Result result=new Result();
        if(outputFormatMapper.cancelShareSampleStatus(id)==1){
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
    public String addOutputFormat(String path, String describe, String username, String faultSet) {
        outputFormatMapper.writeToOutputFormat(path,describe,username,faultSet);
        return "success";
    }

    @Override
    public String showSampleByName(String username) {
        List<Map<String,Object>> list=outputFormatMapper.showSampleByName(username);
        Result result= new Result("访问成功",true,list);
        return JSON.toJSONString(result, JSONFilter.filter);
    }
}
