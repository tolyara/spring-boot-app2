package com.springboot.app2.service.test.prototype;

import org.springframework.stereotype.Component;

@Component
public class TestComponent2 {

    private final Prototype prototype;
    private final Singleton singleton;

    public TestComponent2(Prototype prototype, Singleton singleton) {
        this.prototype = prototype;
        this.singleton = singleton;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public Singleton getSingleton() {
        return singleton;
    }

}
