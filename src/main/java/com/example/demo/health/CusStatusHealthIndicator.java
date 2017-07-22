package com.example.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;

/**
 * Created by jiazhijie on 2017/6/19.
 */
public class CusStatusHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

        int errorCode = check();
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("status", errorCode)
                    .withDetail("message", "服务故障")
                    .build();
        }
        return Health.up().build();

    }

    private int check(){
        // 对监控对象的检测操作
        return HttpStatus.NOT_FOUND.value();
    }
}
