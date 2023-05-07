package com.springboot.app2.entity.test.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Sparrow implements Bird {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void makeSound() {
        logger.info("Sparrow sound ... ");
    }

}
