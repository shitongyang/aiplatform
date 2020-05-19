package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.iscas.aiplatform.service.ModelFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue;

/**
 * @Author yangshitong
 * @Date 2020/5/12 14:01
 * @Version 1.0
 * @Description:模型文件的控制器
 */
@RestController
@CrossOrigin("*")
public class ModelFileController {

    Logger logger= LoggerFactory.getLogger(getClass());
    @Autowired
    private ModelFileService modelFileService;

    @RequestMapping("shareModelFile")
    public String shareModelFile(@RequestBody String message){
        logger.info("共享模型文件"+message);
        JSONObject object = JSONObject.parseObject(message);
        return modelFileService.shareModelFile(object.getIntValue("id"));
    }

    @RequestMapping("cancelShareModelFile")
    public String cancelShareModelFile(@RequestBody String message){
        logger.info("取消共享模型文件"+message);
        JSONObject object = JSONObject.parseObject(message);
        return modelFileService.cancelShareModelFile(object.getIntValue("id"));
    }

    @RequestMapping("showModelFileByName")
    public String showModelFile(@RequestBody String message){
        logger.info("根据用户名展示模型文件"+message);
        JSONObject object = JSONObject.parseObject(message);
        return modelFileService.showModelFileByName(object.getString("username"));
    }
    @RequestMapping("showSharedModelFile")
    public String showSharedModelFile(){
        //JSONObject object = JSONObject.parseObject(message);
        return modelFileService.showSharedModelFile();
    }

    @RequestMapping("insert")
    public String insert(){
        //JSONObject object = JSONObject.parseObject(message);
        int i=modelFileService.addModelFile("1","1","1","1","1");
        return "测试陈宫"+i;
    }


}
