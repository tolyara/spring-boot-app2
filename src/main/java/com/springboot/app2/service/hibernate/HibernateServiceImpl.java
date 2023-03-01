package com.springboot.app2.service.hibernate;

import com.springboot.app2.dao.PetRepository;
import com.springboot.app2.dao.StudentRepository;
import com.springboot.app2.dao.StudentSettingsRepository;
import com.springboot.app2.entity.Pet;
import com.springboot.app2.entity.Student;
import com.springboot.app2.util.LoggingUtil;
import com.springboot.app2.util.RandomUtil;
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

@Service
public class HibernateServiceImpl implements HibernateService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    private final StudentRepository studentRepository;
    private final StudentSettingsRepository studentSettingsRepository;
    private final PetRepository petRepository;
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateServiceImpl(EntityManager entityManager, EntityManagerFactory entityManagerFactory,
                                StudentRepository studentRepository, StudentSettingsRepository studentSettingsRepository,
                                PetRepository petRepository) {
        LoggingUtil.log(logger);
        this.studentRepository = studentRepository;
        this.studentSettingsRepository = studentSettingsRepository;
        this.petRepository = petRepository;
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    @PostConstruct
    public void postConstruct() {
        LoggingUtil.log(logger);
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    @PreDestroy
    public void preDestroy() {
        LoggingUtil.log(logger);
        sessionFactory.close();
    }

    @Override
    public void testFirstCacheLevel() {
//        logger.info("method {}()", Thread.currentThread().getStackTrace()[1].getMethodName());
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
        if (Long.compare(0, id) == 0) return;
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            student.setSupervisorId(RandomUtil.generateRandomLongValue());
            tx.commit();

//            The code directly invokes the tx.commit method without invoking the session.save or session.update.
//            Since the person object is in the persistent state, the change to the field will automatically get saved to the database.
        }
    }

    @Override
    public void testCascadeTypePersist() {
        Student student = new Student();
        student.setName("stud-" + RandomUtil.generateRandomLongValue());

        Pet pet = new Pet();
        pet.setNick("Pet-" + RandomUtil.generateRandomLongValue());
        pet.setStudent(student);

        student.getPets().add(pet);
        studentRepository.save(student);

        // without cascade it will be an error
        // org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance before flushing: com.springboot.app2.entity.Pet
    }

    @Override
    public void testCascadeTypeMerge(Long id) {

    }

    /*
        he detach operation removes the entity from the persistent context. When we use CascadeType.DETACH, the child entity will also get removed from the persistent context.
     */
    @Override
    public void testCascadeTypeDetach(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, id);
            if (student == null) return;
            Pet pet = student.getPets().get(0);

            logger.info("{}", session.contains(student)); // true
            logger.info("{}", session.contains(pet)); // true

            session.detach(student);
            logger.info("{}", session.contains(student)); // false
            logger.info("{}", session.contains(pet)); // true if cascade DETACH present, false otherwise
        }
    }

    @Override
    public void testCascadeTypeRefresh(Long id) {

    }

    @Override
    public void testCascadeTypeRemove(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return;
        studentRepository.delete(student);

        // without cascade it will be an error
        // org.postgresql.util.PSQLException: ОШИБКА: UPDATE или DELETE в таблице "students" нарушает ограничение внешнего ключа "fka8kn88hrajcy2c0td4hc5p452" таблицы "pets"
    }

    @Override
    public void testOrphanRemoval(Long id) {

    }

}
