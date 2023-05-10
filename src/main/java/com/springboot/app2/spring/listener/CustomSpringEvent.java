package com.springboot.app2.spring.listener;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * https://www.baeldung.com/spring-events
 *
 * Let’s create a simple event class — just a placeholder to store the event data.
 *
 */
public class CustomSpringEvent extends ApplicationEvent {

    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
