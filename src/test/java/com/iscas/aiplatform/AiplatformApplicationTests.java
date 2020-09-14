package com.iscas.aiplatform;

import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.service.OutputFormatService;
import com.iscas.aiplatform.service.TrainProcedureService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AiplatformApplicationTests {

    @Resource
    private ModelFileService modelFileService;

    @Resource
    private OutputFormatService outputFormatService;

    @Resource
    private TrainProcedureService trainService;
    @Test
    void contextLoads() {

        //System.out.println(outputFormatService.showSharedSample());
    }

    @Test
    void serviceTest(){

        //System.out.println(modelFileService.showModelFileByName("张三"));
    }

    @Test
    void trainServiceTest(){
       // TrainProcedure trainProcedure = new TrainProcedure("张三2222","张三的程序","///","//","备注","张三");

        //trainProcedure.setCreateTime(TimeUtil.getCurrentTime());
        //System.out.println(trainService.upLoadProcedure(trainProcedure));

        //System.out.println(trainService.listProcedures("张三"));

        TrainInstance trainInstance = new TrainInstance("33","33",1,"33","22",
                "22","222","11",1,3,"22",23,"33","333");

       // System.out.println(trainService.listInstances("333"));
    }

}
