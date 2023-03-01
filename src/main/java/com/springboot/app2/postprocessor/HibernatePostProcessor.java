package com.springboot.app2.postprocessor;

import com.springboot.app2.service.hibernate.HibernateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HibernatePostProcessor implements BeanPostProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof HibernateService) {
            logger.info("BeforeInitialization : {}", beanName);
        }
        return bean;  // you can return any other object as well
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof HibernateService) {
            logger.info("AfterInitialization : {}", beanName);
        }
        return bean;  // you can return any other object as well
    }

}
