package com.freedom.springsix.bean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages ="com.freedom.springsix.bean.lifecycle")
public class AppConfig {

//    @Bean
//    public BeanLifeCycleDemo beanLifeCycleDemo() {
//        return new BeanLifeCycleDemo();
//    }
}
