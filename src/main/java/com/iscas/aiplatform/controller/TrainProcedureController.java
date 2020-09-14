package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.service.TrainProcedureService;
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
    private TrainProcedureService trainProcedureService;

    @GetMapping("/getProcedures")
    public String getProcedure(@RequestParam("username")String username){

        return trainProcedureService.listProcedures(username);
    }

    @DeleteMapping("/deleteProcedure")
    public String deleteProcedure(@RequestParam("id")int id){

        return trainProcedureService.deleteProcedure(id);
    }

    @GetMapping("/getProceduresName")
    public List<Map<String,Object>> listProceduresName(@RequestParam("username")String username){
        return trainProcedureService.listProceduresName(username);
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
        return trainProcedureService.listFaultsByDes(formatDes, username);
    }
    
}
