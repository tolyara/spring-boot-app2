package com.springboot.app2.service.hibernate;

import com.springboot.app2.entity.Student;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateServiceImpl implements HibernateService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EntityManager entityManager;

    @Autowired
    public HibernateServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void testFirstCacheLevel() {
        Session session = entityManager.unwrap(Session.class);
        logger.info("method {}()", Thread.currentThread().getStackTrace()[1].getMethodName());

        // caching, same entity
        Student student1 = session.get(Student.class, 1L);
        logger.info("student1 = {}", student1);
        Student student2 = session.get(Student.class, 1L);
        logger.info("student2 = {}", student2);

        // no caching, different entities
//        Student student1 = session.load(Student.class, 1L);
//        logger.info("student1 = {}", student1);
//        Student student2 = session.load(Student.class, 2L);
//        logger.info("student2 = {}", student2);
    }

    @Override
    public void testSecondCacheLevel() {

    }

}
