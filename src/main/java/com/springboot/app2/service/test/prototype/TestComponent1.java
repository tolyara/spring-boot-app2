package com.springboot.app2.service.test.prototype;

import org.springframework.stereotype.Component;

@Component
public class TestComponent1 {

    private final Prototype prototype;
    private final Singleton singleton;

    public TestComponent1(Prototype prototype, Singleton singleton) {
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
