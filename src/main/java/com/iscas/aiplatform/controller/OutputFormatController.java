package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.service.OutputFormatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/5/12 15:31
 * @Version 1.0
 * @Description:进行样本数据的共享和取消共享
 */
@RestController
@CrossOrigin("*")
public class OutputFormatController {

    Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private OutputFormatService outputFormatService;

    @RequestMapping("shareSample")
    public String shareSample(@RequestBody String message){
        JSONObject object = JSONObject.parseObject(message);
        logger.info("共享样本数据"+message);
        return outputFormatService.shareSample(object.getIntValue("id"));
    }

    @RequestMapping("cancelShareSample")
    public String cancelShareSample(@RequestBody String message){
        logger.info("取消共享样本数据"+message);
        JSONObject object = JSONObject.parseObject(message);
        return outputFormatService.cancelShareSample(object.getIntValue("id"));
    }

    @RequestMapping("showSampleByName")
    public String showSampleByName(@RequestBody String message){
        logger.info("根据用户名展示样本数据"+message);
        JSONObject object = JSONObject.parseObject(message);
        return outputFormatService.showSampleByName(object.getString("username"));
    }

    @RequestMapping("showSharedSample")
    public String showSharedSample(){
        return outputFormatService.showSharedSample();
    }

    @RequestMapping("getFaultSet")
    public String getFaultSet(){
       return outputFormatService.getFaultSet();
    }

    @DeleteMapping("deleteOutputFormat")
    public String deleteOutputFormat(@RequestParam("id") int id){
        return outputFormatService.deleteOutputFormat(id);
    }

    @DeleteMapping("deleteSample")
    public String deleteSample(@RequestParam("id") int id){
        return outputFormatService.deleteOutputFormat(id);
    }

    @GetMapping("showOutputFormatByName")
    public String showOutputFormatName(@RequestParam String username){
        logger.info("根据用户名展示样本输出格式"+username);
        //JSONObject object = JSONObject.parseObject(message);
        return outputFormatService.showSampleByName(username);
    }


    @GetMapping("/getOutputFormatDes")
    public List<Map<String,Object>> getOutputFormatDes(@RequestParam String username){
        return outputFormatService.listOutputFormatDes(username);
    }
}
