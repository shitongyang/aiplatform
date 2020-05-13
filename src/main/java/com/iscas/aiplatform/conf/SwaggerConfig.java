package com.iscas.aiplatform.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author yangshitong
 * @Date 2020/5/13 10:05
 * @Version 1.0
 * @Description:
 */

@Configuration

@EnableSwagger2

public class SwaggerConfig {

    @Bean

    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)

                .apiInfo(apiInfo())

                .select()

                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //添加ApiOperiation注解的被扫描

                .paths(PathSelectors.any())

                .build();

    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("swagger和springBoot整合").description("swagger的API文档")

                .version("1.0").build();

    }

}

//作者：程序员BUG
//        链接：https://www.jianshu.com/p/f4fb5e9899fc
//        来源：简书
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
