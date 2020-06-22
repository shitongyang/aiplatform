package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.mapper.ModelFileMapper;
import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.utils.JSONFilter;
import com.iscas.aiplatform.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private ModelFileMapper modelFileMapper;

    @Override
    public int addModelFile(String modelName, String modelDes, String modelFormat, String username, String modelStorePath) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        String time=sdf.format(date);
        return modelFileMapper.insertModelFile(modelName, modelDes, modelFormat, username, modelStorePath, time);
    }

    @Override
    public String shareModelFile(int id) {
        Result result = new Result();
        if(modelFileMapper.shareModelFile(id) == 1){
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
        Result result = new Result();
        if (modelFileMapper.cancelShareModelFile(id) == 1){
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

        List<Map<String,Object>> resultList = modelFileMapper.selectModelFileByName(username);

        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("访问成功");
        result.setDetail(OutputFormatServiceImpl.addNo(resultList));

        return JSON.toJSONString(result, JSONFilter.filter);
    }

    @Override
    public String showSharedModelFile() {
        List<Map<String,Object>> resultList = modelFileMapper.selectSharedModelFile();
        Result result = new Result("访问共享模型文件成功",true,OutputFormatServiceImpl.addNo(resultList));
        return JSON.toJSONString(result, JSONFilter.filter);
    }

    @Override
    public String getModelFormat() {

        List<Map<String,Object>> resultList = modelFileMapper.selectModelFormat();
        return JSON.toJSONString(new Result("获取成功",true,resultList));
    }

    @Override
    public String deleteModelFile(int id) {
        Result result = new Result();
        if(modelFileMapper.deleteModelFile(id) == 1){
            result.setSuccess(true);
            result.setMsg("删除模型文件成功");
        }else {
            result.setSuccess(false);
            result.setMsg("删除模型文件失败");
        }
        return JSON.toJSONString(result);
    }

}
