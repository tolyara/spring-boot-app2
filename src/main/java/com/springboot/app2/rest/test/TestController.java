package com.springboot.app2.rest.test;

import com.springboot.app2.config.SpringConfig;
import com.springboot.app2.entity.test.bean.Pelican;
import com.springboot.app2.entity.test.bean.Sparrow;
import com.springboot.app2.service.test.bean.BirdService;
import com.springboot.app2.service.test.prototype.PrototypeBean;
import com.springboot.app2.service.test.prototype.SingletonBean;
import com.springboot.app2.service.test.prototype.TestComponent1;
import com.springboot.app2.service.test.prototype.TestComponent2;
import com.springboot.app2.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TestComponent1 testComponent1;
    private final TestComponent2 testComponent2;

    private final BirdService birdService;
    private final Sparrow sparrow;
    private final Pelican pelican;

    public TestController(TestComponent1 testComponent1, TestComponent2 testComponent2,
                          BirdService birdService, Sparrow sparrow, Pelican pelican
    ) {
        this.testComponent1 = testComponent1;
        this.testComponent2 = testComponent2;

        this.birdService = birdService;
        this.sparrow = sparrow;
        this.pelican = pelican;
    }

    @GetMapping("/test2")
    public void test2() {
        birdService.makeBirdsSound(Arrays.asList(sparrow, pelican));
    }

    @GetMapping("/test")
    public void test() {
        LoggingUtil.log(logger);

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfig.class);

        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        // Both beans were initialized only once, at the startup of the application context
        System.out.println(firstPrototype.equals(secondPrototype));

//        System.out.println(testComponent1.getPrototype() == testComponent2.getPrototype()); // false
//        System.out.println(testComponent1.getSingleton() == testComponent2.getSingleton()); // true
    }

}
