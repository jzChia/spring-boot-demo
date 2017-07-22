package com.example.demo;

import com.example.demo.state.Events;
import com.example.demo.state.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.config.annotatedtion.web.configuration.EnableWebSecurity;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableTransactionManagement
@EnableConfigurationProperties
@ComponentScan(basePackages = { "com.example.demo" })
public class DemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//		HibernateJpaSessionFactoryBean fact = new HibernateJpaSessionFactoryBean();
//		fact.setEntityManagerFactory(emf);
//		return fact;
//	}
}
