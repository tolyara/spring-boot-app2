package com.springboot.app2.service.test.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;

/**
 *
 * https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
 *
 * In order to describe the problem, let's configure the following beans: SingletonBean and PrototypeBean
 *
 */
public class SingletonBean {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean() {
        logger.info("Singleton instance created");
    }

    public PrototypeBean getPrototypeBean() {
        logger.info(String.valueOf(LocalTime.now()));
        return prototypeBean;
    }

}
