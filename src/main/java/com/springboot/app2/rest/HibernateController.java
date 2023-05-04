package com.springboot.app2.rest;

import com.springboot.app2.service.hibernate.HibernateService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HibernateController {

    private final HibernateService hibernateService;

    public HibernateController(HibernateService hibernateService) {
        this.hibernateService = hibernateService;
    }

    @PostMapping("/hibernate")
    public void testHibernateSave() {
//        hibernateService.testFirstCacheLevel();
//        hibernateService.testDirtyCheck(id);

        hibernateService.testCascadeTypePersist();
    }

    @GetMapping("/hibernate/{id}/{name}")
    public Object testHibernateGet(@PathVariable Long id, @PathVariable String name) {
//        hibernateService.testCascadeTypeMerge(id, name);
//        hibernateService.testCascadeTypeRefresh(id);

//        hibernateService.testOrphanRemoval(id);

//        return hibernateService.testNamedQuery(id, name);

//        hibernateService.testInheritance(id, name);
//        return null;

//        return hibernateService.testFetch(id, name);

        return hibernateService.testCache(id, name);
    }

    @DeleteMapping("/hibernate/{id}")
    public void testHibernateDelete(@PathVariable Long id) {
        hibernateService.testCascadeTypeRemove(id);
    }

}
