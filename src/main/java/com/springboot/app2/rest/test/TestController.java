package com.springboot.app2.rest.test;

import com.springboot.app2.service.test.prototype.TestComponent1;
import com.springboot.app2.service.test.prototype.TestComponent2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestComponent1 testComponent1;
    private final TestComponent2 testComponent2;

    public TestController(TestComponent1 testComponent1, TestComponent2 testComponent2) {
        this.testComponent1 = testComponent1;
        this.testComponent2 = testComponent2;
    }

    @GetMapping("/test")
    public void test() {
        System.out.println(testComponent1.getPrototype() == testComponent2.getPrototype()); // false
        System.out.println(testComponent1.getSingleton() == testComponent2.getSingleton()); // true
    }

}
