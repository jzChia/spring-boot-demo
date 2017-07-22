package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiazhijie on 2017/7/18.
 */
@Configuration
@ConfigurationProperties(prefix = "myProps.test")
@PropertySource("classpath:config.properties")
public class MyTestPro {
    Map<String,List<String>> foo = new HashMap<>();

    public Map<String, List<String>> getFoo() {
        return foo;
    }

    public void setFoo(Map<String, List<String>> foo) {
        this.foo = foo;
    }
}
