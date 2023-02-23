package com.springboot.app2.config;

import com.springboot.app2.servlet.CustomServlet;
import com.springboot.app2.servlet.listener.CustomServletListener;
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
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

    /*
        With the Spring @Bean approach, we can use the ServletListenerRegistrationBean class to register the Listener.
     */
//    @Bean
//    public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
//        ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<>();
//        bean.setListener(new CustomServletListener());
//        return bean;
//    }

}
