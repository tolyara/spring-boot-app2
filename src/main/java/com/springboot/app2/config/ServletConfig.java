package com.springboot.app2.config;

import com.springboot.app2.servlet.CustomServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServletConfig implements WebMvcConfigurer {

    @Bean
    public ServletRegistrationBean<CustomServlet> customServletBean() {
        ServletRegistrationBean<CustomServlet> bean = new ServletRegistrationBean<>(new CustomServlet(), "/servlet");
        return bean;
    }

}
