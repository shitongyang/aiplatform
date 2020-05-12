package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.iscas.aiplatform.service.ModelFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private ModelFileService modelFileService;

    @RequestMapping("shareModelFile")
    public String shareModelFile(@RequestParam("id") int id){

        return modelFileService.shareModelFile(id);
    }

    @RequestMapping("cancelShareModelFile")
    public String cancelShareModelFile(@RequestParam("id") int id){

        return modelFileService.cancelShareModelFile(id);
    }

    @RequestMapping("showModelFile")
    public String showModelFile(@RequestParam("username")String username){
       return modelFileService.showModelFileByName(username);
    }

}
