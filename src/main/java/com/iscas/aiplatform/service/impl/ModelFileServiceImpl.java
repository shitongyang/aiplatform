package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.mapper.ModelFileMapper;
import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.utils.JSONFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/5/12 13:53
 * @Version 1.0
 * @Description:
 */
@Service
public class ModelFileServiceImpl implements ModelFileService {

    @Autowired
    private ModelFileMapper modelFileMapper;

    @Override
    public int addModelFile(String modelName, String modelDes, String modelFormat, String username, String modelStorePath) {
        return modelFileMapper.insertModelFile(modelName,modelDes,modelFormat,username,modelStorePath);
    }

    @Override
    public String shareModelFile(int id) {
        Result result=new Result();
        if(modelFileMapper.shareModelFile(id)==1){
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
    public String cancelShareModelFile(int id) {
        Result result=new Result();
        if(modelFileMapper.cancelShareModelFile(id)==1){
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
    public String showModelFileByName(String username) {

        List<Map<String,Object>> resultList=modelFileMapper.selectModelFileByName(username);
        Result result=new Result();
        result.setSuccess(true);
        result.setMsg("访问成功");
        result.setDetail(resultList);

        return JSON.toJSONString(result, JSONFilter.filter);
    }

}
