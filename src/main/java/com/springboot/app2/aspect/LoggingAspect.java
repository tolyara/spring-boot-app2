package com.springboot.app2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.springboot.app2.service.hibernate.HibernateService.*(..))")
    public void allHibernateMethods() {}

    @Before("allHibernateMethods()")
    public void beforeHibernateMethodAdvice(JoinPoint jp) {
        MethodSignature ms = (MethodSignature) jp.getSignature();
        logger.info("method {}.{}() called", ms.getMethod().getDeclaringClass().getSimpleName(), ms.getMethod().getName());
    }

}
