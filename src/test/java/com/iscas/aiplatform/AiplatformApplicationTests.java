package com.iscas.aiplatform;

import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.service.OutputFormatService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
class AiplatformApplicationTests {

    @Resource
    private ModelFileService modelFileService;

    @Resource
    private OutputFormatService outputFormatService;

    @Test
    void contextLoads() {
        System.out.println(outputFormatService.showSharedSample());
    }

    @Test
    void serviceTest(){
        System.out.println(modelFileService.showModelFileByName("张三"));
    }
}
