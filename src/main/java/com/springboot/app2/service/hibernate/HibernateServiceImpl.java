package com.springboot.app2.service.hibernate;

import com.springboot.app2.dao.PetRepository;
import com.springboot.app2.dao.StudentRepository;
import com.springboot.app2.dao.StudentSettingsRepository;
import com.springboot.app2.entity.Pet;
import com.springboot.app2.entity.Student;
import com.springboot.app2.entity.inheritance.mappedsuperclass.InhClient;
import com.springboot.app2.entity.inheritance.mappedsuperclass.InhEmployee;
import com.springboot.app2.util.LoggingUtil;
import com.springboot.app2.util.RandomUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /*
        The persist operation makes a transient instance persistent. Cascade Type PERSIST propagates the persist operation from a parent to a child entity.
     */
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

    /*
        The merge operation copies the state of the given object onto the persistent object with the same identifier. CascadeType.MERGE propagates the merge operation from a parent to a child entity.
     */
    @Override
    public void testCascadeTypeMerge(Long id, String name) {
        try (Session session = sessionFactory.openSession()) {
            Pet dbPet = petRepository.findByStudentId(id).get(0);
            Student student = new Student(id);
            Pet pet = new Pet(dbPet.getId(), student);
            student.getPets().add(pet);

            Transaction tx = session.beginTransaction();
            student.setName("newName" + RandomUtil.generateRandomLongValue());
            pet.setNick("newNick" + RandomUtil.generateRandomLongValue());
            session.merge(student); // value "newNick" for pet won't be updated if cascade MERGE not set
            session.flush();
            tx.commit();
        }
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

    /*
        Refresh operations reread the value of a given instance from the database.
        In some cases, we may change an instance after persisting in the database, but later we need to undo those changes.
        In that kind of scenario, this may be useful.
        When we use this operation with Cascade Type REFRESH, the child entity also gets reloaded from the database whenever the parent entity is refreshed.
     */
    @Override
    public void testCascadeTypeRefresh(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.get(Student.class, id);

            logger.info("student before merge : {}", student);
            logger.info("pet before merge : {}", !student.getPets().isEmpty() ? student.getPets().get(0) : "null");
            try (Session session2 = sessionFactory.openSession()) {
                Transaction tx = session2.beginTransaction();
                Student studentForUpdate = new Student(id);
                Pet petForUpdate = new Pet(student.getPets().get(0).getId(), studentForUpdate);
                studentForUpdate.setName("testName" + RandomUtil.generateRandomLongValue());
                petForUpdate.setNick("testNick" + RandomUtil.generateRandomLongValue());
                studentForUpdate.getPets().add(petForUpdate);
                session2.merge(studentForUpdate);
                session2.flush();
                tx.commit();
            }

            logger.info("student before refresh : {}", student);
            session.refresh(student);

            // value "testNick" for pet won't be refreshed if cascade REFRESH not set
            logger.info("student : {}", student);
            logger.info("pet : {}", !student.getPets().isEmpty() ? student.getPets().get(0) : "null");
        }
    }

    /*
        As the name suggests, the remove operation removes the row corresponding to the entity from the database and also from the persistent context.
     */
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
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return;

        logger.info("{} student pets before update: {}", LoggingUtil.APP, student.getPets().stream().map(Pet::toString).collect(Collectors.joining(", ")));
//        student.setPets(new ArrayList<>()); // will cause exception -> org.hibernate.HibernateException: A collection with cascade="all-delete-orphan" was no longer referenced by the owning entity instance: com.springboot.app2.entity.Student.pets
        student.getPets().clear();
        studentRepository.save(student);

        // pets won't be updated if orphanRemoval set to false
        logger.info("{} student pets after update: {}", LoggingUtil.APP, petRepository.findByStudentId(id).stream().map(Pet::toString).collect(Collectors.joining(", ")));
    }

    @Override
    public Object testNamedQuery(Long id, String name) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createNamedQuery("Pet.byStudent", Pet.class);
            query.setParameter(1, id);

            List<Pet> pets = query.getResultList();
            logger.info("Pets : {}", pets);
            return pets;
        }

//        try (Session session = sessionFactory.openSession()) {
//            Query query = session.createNamedQuery("Pet.byNick", Pet.class);
//            query.setParameter(1, "Test");
//
//            List<Pet> pets = query.getResultList();
//            logger.info("Pets : {}", pets);
//            return pets;
//        }
    }

    @Override
    public void testInheritance(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();

//            InhClient inhClient = new InhClient(0L, "client1", "address1"); // org.hibernate.PersistentObjectException: detached entity passed to persist: com.springboot.app2.entity.inheritance.mappedsuperclass.InhClient

//            InhClient inhClient = new InhClient();
//            inhClient.setName("client1");
//            inhClient.setAddress("address1");

            InhEmployee object = new InhEmployee();
            object.setName("employee1");
            object.setCompany("company1");

            session.persist(object);
            session.flush();
            tx.commit();
        }
    }

}
