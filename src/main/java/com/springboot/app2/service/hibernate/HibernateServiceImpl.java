package com.springboot.app2.service.hibernate;

import com.springboot.app2.entity.Student;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HibernateServiceImpl implements HibernateService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public final int MAX_ID = 10000;

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateServiceImpl(EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @PostConstruct
    public void postConstruct() {
        logger.info("method {}() called", Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("Closing sessionFactory");
        sessionFactory.close();
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

    @Override
    public void testDirtyCheck(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setSupervisorId((long) new Random().nextInt(MAX_ID) + 1);
            tx.commit();

//            The code directly invokes the tx.commit method without invoking the session.save or session.update.
//            Since the person object is in the persistent state, the change to the field will automatically get saved to the database.
        }
    }

}
