package com.springboot.app2.rest;

import com.springboot.app2.service.hibernate.HibernateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HibernateController {

    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @GetMapping("/hibernate")
    public void testHibernate() {
        hibernateService.testFirstCacheLevel();

//        hibernateService.testSecondCacheLevel();
    }

}
