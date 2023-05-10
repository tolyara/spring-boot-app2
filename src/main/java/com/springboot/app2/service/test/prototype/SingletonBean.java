package com.springboot.app2.service.test.prototype;

import com.springboot.app2.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.time.LocalTime;

/**
 *
 * https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
 *
 * In order to describe the problem, let's configure the following beans: SingletonBean and PrototypeBean
 *
 */
//public class SingletonBean {
public class SingletonBean implements ApplicationContextAware {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplicationContext applicationContext;

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean() {
//        logger.info("Singleton instance created");
    }

    public PrototypeBean getPrototypeBean() {
        LoggingUtil.log(logger);
        return applicationContext.getBean(PrototypeBean.class);

//        return prototypeBean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
