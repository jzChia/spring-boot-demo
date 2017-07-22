package com.example.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by jiazhijie on 2017/6/19.
 */
@Component
public class Receiver {

    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }


    @RabbitListener(queues = "hi")
    public void processhi(String hi) {
        System.out.println("Receiver : " + hi);
    }

}
