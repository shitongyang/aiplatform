package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : lvxianjin
 * @Date: 2020/5/11 10:08
 * @Description:
 */
@Controller
@CrossOrigin("*")
public class SampleController {
    @Autowired
    private SampleService sampleService;
    @RequestMapping("creatSample")
    public void creatSample(int id){
        sampleService.createSample(id);
    }
    @RequestMapping("stopSample")
    public void stopSample(int id){
        sampleService.createSample(id);
    }
}
