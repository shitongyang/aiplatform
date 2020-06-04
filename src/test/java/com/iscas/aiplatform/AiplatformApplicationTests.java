package com.iscas.aiplatform;

import com.iscas.aiplatform.service.ModelFileService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@SpringBootTest
class AiplatformApplicationTests {

    @Resource
    private ModelFileService modelFileService;
    @Test
    void contextLoads() {
    }

    @Test
    void serviceTest(){
        System.out.println(modelFileService.getModelFormat());
    }
}
