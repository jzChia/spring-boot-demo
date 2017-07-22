package com.example.demo.metric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

/**
 * Created by jiazhijie on 2017/6/19.
 */
@Component
public class MyMetric {
    private final CounterService counterService;
    private final GaugeService gaugeService;
    @Autowired
    public MyMetric(CounterService counterService, GaugeService gService) {
        this.counterService = counterService;
        this.gaugeService = gService;
    }
    public void exampleCounterMethod() {
        this.counterService.increment("login.count");
        // reset each minute
    }
    public void exampleGaugeMethod() {
        this.gaugeService.submit("cache.hit", 80.0);
    }
}
