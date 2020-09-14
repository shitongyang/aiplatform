package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.service.TrainInstanceService;
import com.iscas.aiplatform.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author yangShiTong
 * @Date 2020/9/14 11:27
 * @Version 1.0
 * @Description: 训练实例的控制类
 */
@RestController
@CrossOrigin("*")
public class TrainInstanceController {

    @Autowired
    private TrainInstanceService trainInstanceService;

    @PostMapping("/createInstance")
    public String createInstance(@RequestBody String message){

        JSONObject jsonObject= JSON.parseObject(message);
        TrainInstance trainInstance = JSON.toJavaObject(jsonObject,TrainInstance.class);

        trainInstance.setStatus("未运行");
        trainInstance.setRunTime(0);
        trainInstance.setCreateTime(TimeUtil.getCurrentTime());
        return trainInstanceService.insertTrainInstance(trainInstance);
    }

    @GetMapping("/getInstances")
    public List<Map<String,Object>> getInstances(@RequestParam("username") String username){
        return trainInstanceService.listInstances(username);
    }

}
