package com.example.demo.security;

//import com.example.demo.Domain.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;

/**
 * Created by jiazhijie on 2017/6/9 0009.
 */
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        System.out.println("userDetailsService");
//        auth.userDetailsService(myUserDetailsService());
//    }
//
//
//    /**
//     * 自定义UserDetailsService，从数据库中读取用户信息
//     * @return
//     */
//    @Bean
//    public MyUserDetailsService myUserDetailsService(){
//        return new MyUserDetailsService();
//    }
//}
