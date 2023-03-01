package com.springboot.app2.util;

import org.slf4j.Logger;

public class LoggingUtil {

    public static final String APP = "APP2:";

    public static void log(Logger logger) {
        logger.info("{} class {} method {}()", APP, Thread.currentThread().getStackTrace()[2].getClassName(),
                Thread.currentThread().getStackTrace()[2].getMethodName());
    }

}
