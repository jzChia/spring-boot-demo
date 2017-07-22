package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jiazhijie on 2017/7/13.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo")
//                .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //.paths(or(regex("/demo/.*")))//过滤的接口
                .build()
                .apiInfo(demoApiInfo());
    }


    private ApiInfo demoApiInfo() {
        return new ApiInfoBuilder()
                .title("Electronic Health Record(EHR) Platform API")//大标题
                .description("EHR Platform's REST API, all the applications could access the Object model data via JSON.")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("NO terms of service")
                .contact("jzjz")//作者
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
