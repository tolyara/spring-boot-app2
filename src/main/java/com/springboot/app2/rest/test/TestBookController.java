package com.springboot.app2.rest.test;

import com.springboot.app2.entity.fortest.TestBook;
import com.springboot.app2.service.test.prototype.TestComponent1;
import com.springboot.app2.service.test.prototype.TestComponent2;
import com.springboot.app2.util.LoggingUtil;
import com.springboot.app2.util.RandomUtil;
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

    @Autowired
    public TestBookController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/testbook")
    @Transactional
    public void testBook() {
        LoggingUtil.log(logger);

//        TestBook testBook = new TestBook();
//        testBook.setName("testbook" + RandomUtil.generateRandomLongValue());
//        entityManager.persist(testBook);
//        entityManager.flush();

        TestBook testBook1 = entityManager.find(TestBook.class, 1L);
        logger.info(testBook1.getName());
    }

}
