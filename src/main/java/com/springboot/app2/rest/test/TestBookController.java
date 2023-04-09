package com.springboot.app2.rest.test;

import com.springboot.app2.dao.TestBookRepository;
import com.springboot.app2.entity.fortest.TestBook;
import com.springboot.app2.service.hibernate.HibernateService;
import com.springboot.app2.util.LoggingUtil;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final EntityManager entityManager;
//    private final HibernateService hibernateService;
    private final TestBookRepository testBookRepository;

    @Autowired
    public TestBookController(EntityManager entityManager, TestBookRepository testBookRepository) {
        this.entityManager = entityManager;
        this.testBookRepository = testBookRepository;
    }

    @GetMapping("/testbook")
    @Transactional
    public void testBook() {
        LoggingUtil.log(logger);

//        TestBook testBook = new TestBook();
//        testBook.setName("testbook" + RandomUtil.generateRandomLongValue());
//        entityManager.persist(testBook);
//        entityManager.flush();

        TestBook testBook1 = testBookRepository.findById(1L).get();
        logger.info("book : {}", testBook1.getName());
        logger.info("author : {} {}", testBook1.getAuthor().getFirstName(), testBook1.getAuthor().getLastName());
    }

}
