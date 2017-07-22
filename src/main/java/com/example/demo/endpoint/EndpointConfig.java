package com.example.demo.endpoint;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by jiazhijie on 2017/6/19.
 */
@Configuration
public class EndpointConfig {

    @Bean
    public static Endpoint<Map<String, Object>> servertime() {
        return new ServerTimeEndpoint();
    }
}
