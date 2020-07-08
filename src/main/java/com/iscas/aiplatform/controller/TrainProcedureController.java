package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.service.TrainService;
import com.iscas.aiplatform.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/7/1 10:58
 * @Version 1.0
 * @Description:
 */

@RestController
@CrossOrigin("*")
public class TrainProcedureController {

    @Autowired
    private TrainService trainService;
    @GetMapping("/getProcedures")
    public String getProcedure(@RequestParam("username")String username){

        return trainService.listProcedures(username);
    }

    @DeleteMapping("/deleteProcedure")
    public String deleteProcedure(@RequestParam("id")int id){

        return trainService.deleteProcedure(id);
    }

    @GetMapping("/getProceduresName")
    public List<Map<String,Object>> listProceduresName(@RequestParam("username")String username){
        return trainService.listProceduresName(username);
    }

    /**
     * author: YangShiTong
     * description: 根据用户输入的描述和用户名查询故障集
     * @param
     * @date 2020/7/8 11:38
     * @return
     */
    @GetMapping("/getFaultsByDes")
    public List<Map<String,Object>> getFaultsByDes(@RequestParam("formatDes")String formatDes,@RequestParam("username")String username){
        return trainService.listFaultsByDes(formatDes, username);
    }

    @PostMapping("/createInstance")
    public String createInstance(@RequestBody String message){

        JSONObject jsonObject=JSON.parseObject(message);
        TrainInstance trainInstance = JSON.toJavaObject(jsonObject,TrainInstance.class);

        trainInstance.setStatus("未运行");
        trainInstance.setRunTime(0);
        trainInstance.setCreateTime(TimeUtil.getCurrentTime());
        return trainService.insertTrainInstance(trainInstance);
    }

    @GetMapping("/getInstances")
    public List<Map<String,Object>> getInstances(@RequestParam("username") String username){
        return trainService.listInstances(username);
    }
}
