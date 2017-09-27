package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by jiazhijie on 2017/7/19.
 */
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30)
//public class RedisSpringSession {
//
////    @Bean
////    public JedisConnectionFactory connectionFactory() {
////        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
////
////        jedisConnectionFactory.setUsePool(true);
////        jedisConnectionFactory.setTimeout(2000);
////        jedisConnectionFactory.setDatabase(2);
////
////        return jedisConnectionFactory;
////    }
//}
