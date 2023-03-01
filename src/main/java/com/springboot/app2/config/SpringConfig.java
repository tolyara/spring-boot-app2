package com.springboot.app2.config;

import com.springboot.app2.postprocessor.HibernatePostProcessor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;


@Configuration
//@ComponentScan(basePackages = "com.springboot.app2")
@EnableTransactionManagement
public class SpringConfig {

//    @Bean
//    public PlatformTransactionManager platformTransactionManager() {
//        return new JtaTransactionManager();
//    }

    @Bean
    public HibernatePostProcessor hibernatePostProcessor() {
        return new HibernatePostProcessor();
    }

}
