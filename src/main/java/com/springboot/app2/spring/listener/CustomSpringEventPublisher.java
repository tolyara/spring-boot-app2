package com.springboot.app2.spring.listener;

import com.springboot.app2.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Now let’s create a publisher of that event. The publisher constructs the event object and publishes it to anyone who's listening.
 */

@Component
public class CustomSpringEventPublisher {

    public static final String APP2_EVENT = LoggingUtil.APP + " CUSTOM EVENT:";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public CustomSpringEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishCustomEvent(final String message) {
        logger.info("{} Publishing custom event. ", APP2_EVENT);
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
