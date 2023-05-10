package com.springboot.app2.spring.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Notice how our custom listener is parametrized with the generic type of custom event, which makes the onApplicationEvent() method type-safe.
 * This also avoids having to check if the object is an instance of a specific event class and casting it.
 *
 * And, as already discussed (by default Spring events are synchronous), the doStuffAndPublishAnEvent() method blocks until all listeners finish processing the event.
 */

@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        logger.info("{} Received spring custom event - {}", CustomSpringEventPublisher.APP2_EVENT, event.getMessage());
    }

}
