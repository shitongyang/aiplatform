package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.service.OutputFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yangshitong
 * @Date 2020/5/12 15:31
 * @Version 1.0
 * @Description:进行样本数据的共享和取消共享
 */
@RestController
@CrossOrigin("*")
public class OutputFormatController {

    @Autowired
    private OutputFormatService outputFormatService;

    @RequestMapping("shareSample")
    public String shareSample(@RequestParam("id") int id){

        return outputFormatService.shareSample(id);
    }

    @RequestMapping("cancelShareSample")
    public String cancelShareSample(@RequestParam("id") int id){
        return outputFormatService.cancelShareSample(id);
    }

}
