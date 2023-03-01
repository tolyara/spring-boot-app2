package com.springboot.app2.service.hibernate;

public interface HibernateService {

    void testFirstCacheLevel();

    void testSecondCacheLevel();

    void testDirtyCheck(Long id);

    void testCascadeType(Long id);

    void testOrphanRemoval(Long id);

}
