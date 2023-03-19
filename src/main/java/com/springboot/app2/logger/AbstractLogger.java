package com.springboot.app2.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractLogger {

    protected final Logger logger;

    protected AbstractLogger(Class<?> loggedClass) {
        this.logger = LoggerFactory.getLogger(loggedClass);
    }

}
