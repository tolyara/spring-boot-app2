package com.springboot.app2.service.hibernate;

public interface HibernateService {

    Object testCache(Long id, String name);
    void testFirstCacheLevel();
    void testSecondCacheLevel();

    void testDirtyCheck(Long id);

    void testCascadeTypePersist();
    void testCascadeTypeMerge(Long id, String name);
    void testCascadeTypeDetach(Long id);
    void testCascadeTypeRefresh(Long id);
    void testCascadeTypeRemove(Long id);

    void testOrphanRemoval(Long id);

    Object testNamedQuery(Long id, String name);

    void testInheritance(Long id, String name);

    Object testFetch(Long id, String name);

}
