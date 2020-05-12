package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : lvxianjin
 * @Date: 2020/5/11 10:08
 * @Description:
 */
@RestController
@CrossOrigin("*")
public class SampleController {
    @Autowired
    private SampleService sampleService;
    @RequestMapping(value = "/creatSample",method = RequestMethod.GET)
    public void creatSample(int id){
        sampleService.createSample(id);
        //System.out.println("123");
    }
    @RequestMapping(value="/stopSample",method = RequestMethod.GET)
    public void stopSample(int id){
        sampleService.createSample(id);
    }
}
