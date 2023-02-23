package com.springboot.app2.config;

import com.springboot.app2.servlet.CustomServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServletConfig implements WebMvcConfigurer {

    /*
        With the Spring @Bean approach, we can use the ServletRegistrationBean class to register the servlet.
     */
//    @Bean
//    public ServletRegistrationBean<CustomServlet> customServletBean() {
//        ServletRegistrationBean<CustomServlet> bean = new ServletRegistrationBean<>(new CustomServlet(), "/servlet");
//        return bean;
//    }

}
