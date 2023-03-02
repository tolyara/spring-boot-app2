package com.springboot.app2.service.hibernate;

public interface HibernateService {

    void testFirstCacheLevel();

    void testSecondCacheLevel();

    void testDirtyCheck(Long id);

    void testCascadeTypePersist();
    void testCascadeTypeMerge(Long id, String name);
    void testCascadeTypeDetach(Long id);
    void testCascadeTypeRefresh(Long id);
    void testCascadeTypeRemove(Long id);

    void testOrphanRemoval(Long id);

    Object testNamedQuery(Long id);

}
