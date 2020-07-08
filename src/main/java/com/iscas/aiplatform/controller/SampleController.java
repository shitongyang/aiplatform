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
    @RequestMapping(value = "/createSample",method = RequestMethod.GET)
    public void createSample(int id){
        sampleService.createSample(id);
    }
    @RequestMapping(value="/stopSample",method = RequestMethod.GET)
    public void stopSample(int id){
        sampleService.stopSample(id);
    }


}
