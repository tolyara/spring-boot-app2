package com.springboot.app2.spring.listener;

import com.springboot.app2.util.LoggingUtil;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupLoader {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CustomSpringEventPublisher eventPublisher;

    public StartupLoader(CustomSpringEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostConstruct
    public void postConstruct() {
        eventPublisher.publishCustomEvent("StartupLoader constructed.");
    }

//    @EventListener
    public void handleContextStart(ContextRefreshedEvent cre) {
        LoggingUtil.log(logger);

//        StudentRepository studentRepository = cre.getApplicationContext().getBean(StudentRepository.class);
//        Student newStudent1 = new Student();
//        newStudent1 = studentRepository.save(newStudent1);
//        newStudent1.setName("startup-stud-" + newStudent1.getId());
//        studentRepository.save(newStudent1);
    }

}
