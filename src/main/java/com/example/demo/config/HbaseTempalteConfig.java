package com.example.demo.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseConfigurationFactoryBean;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * Created by jiazhijie on 2017/8/12.
 */
@Configuration
public class HbaseTempalteConfig {

    @Bean
    public HbaseTemplate getHbaseTempalte(){

        HbaseConfigurationFactoryBean hbaseConfigurationFactory = new HbaseConfigurationFactoryBean();
        hbaseConfigurationFactory.setZkQuorum("127.0.0.1");
        hbaseConfigurationFactory.setZkPort(2181);
        hbaseConfigurationFactory.afterPropertiesSet();
        org.apache.hadoop.conf.Configuration configuration = hbaseConfigurationFactory.getObject();

        HbaseTemplate hbaseTemplate = new HbaseTemplate(configuration);

        return hbaseTemplate;
    }

}
