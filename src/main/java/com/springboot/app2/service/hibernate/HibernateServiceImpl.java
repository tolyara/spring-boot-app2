package com.springboot.app2.service.hibernate;

import com.springboot.app2.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateServiceImpl implements HibernateService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateServiceImpl(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Override
    public void testFirstCacheLevel() {
        logger.info("method {}()", Thread.currentThread().getStackTrace()[1].getMethodName());
        Session session = entityManager.unwrap(Session.class);
        Session session2 = entityManager.unwrap(Session.class);

        /*
            no caching, different sessions
         */
//        testSecondCacheLevel();

        /*
            caching, same entity
         */
        Student student1 = session.get(Student.class, 1L);
        logger.info("student1 = {}", student1);
        Student student2 = session.get(Student.class, 1L);
        logger.info("student2 = {}", student2);

        /*
            no caching, different entities
         */
//        Student student1 = session.get(Student.class, 1L);
//        logger.info("student1 = {}", student1);
//        Student student2 = session.get(Student.class, 2L);
//        logger.info("student2 = {}", student2);
    }

    @Override
    public void testSecondCacheLevel() {
        logger.info("method {}()", Thread.currentThread().getStackTrace()[1].getMethodName());

        try (Session session = sessionFactory.openSession()) {
            Student student1 = session.get(Student.class, 1L);
            logger.info("student1 = {}", student1);
        }
        try (Session session2 = sessionFactory.openSession()) {
            Student student2 = session2.get(Student.class, 1L);
            logger.info("student2 = {}", student2);
        }
    }

}
