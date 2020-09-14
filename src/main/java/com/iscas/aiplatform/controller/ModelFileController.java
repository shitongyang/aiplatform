package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.service.ModelFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return modelFileService.showSharedModelFile();
    }

    @RequestMapping("getModelFormat")
    public String getModelFormat(){
        return modelFileService.getModelFormat();
    }

    @RequestMapping("insert")
    public String insert(){
        int i=modelFileService.addModelFile("1","1","1","1","1");
        return "测试陈宫"+i;
    }

    @DeleteMapping("deleteModelFile")
    public String deleteModelFile(@RequestParam("id") int id){
        return modelFileService.deleteModelFile(id);
    }


}
