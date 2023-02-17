package com.springboot.app2.service;

import com.springboot.app2.dao.StudentRepository;
import com.springboot.app2.dao.StudentSettingsRepository;
import com.springboot.app2.entity.Student;
import com.springboot.app2.entity.StudentSettings;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.LocalDateTime;

@Service
public class TransactionalServiceImpl implements TransactionalService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StudentRepository studentRepository;
    private final StudentSettingsRepository studentSettingsRepository;

    @Resource
//    @Autowired
    private PlatformTransactionManager transactionManager;

    public TransactionalServiceImpl(StudentRepository studentRepository, StudentSettingsRepository studentSettingsRepository) {
        this.studentRepository = studentRepository;
        this.studentSettingsRepository = studentSettingsRepository;
    }

    @Override
    public Student updateStudent(Student student) {
//        Student newStudent1 = new Student();
//        newStudent1 = studentRepository.save(newStudent1);
//        newStudent1.setName("stud-" + newStudent1.getId());
//        studentRepository.save(newStudent1);

//        updateStudentTransactional(student);

        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        definition.setTimeout(3);

        TransactionStatus status = transactionManager.getTransaction(definition);

        Student existingStudent = null;
        try {
            existingStudent = updateStudentData(student);
            updateStudentSettings(existingStudent);
            throwTestException(student);
            transactionManager.commit(status);
        } catch (Exception e) {
            logger.error("Student was not updated, cause : " + e);
            transactionManager.rollback(status);
            throw e;
        }
        return existingStudent;
    }

    @Transactional
    public Student updateStudentTransactional(Student student) {
        Student existingStudent = updateStudentData(student);
        updateStudentSettings(existingStudent);
        throwTestException(student);
        return existingStudent;
    }

//    @Transactional
    private Student updateStudentData(Student student) {
        Student existing = studentRepository.findById(student.getId()).get();
        existing.setName(student.getName());
        existing.setGrade(student.getGrade());
        return studentRepository.save(existing);
    }

//    @Transactional // REQUIRED by default, Support a current transaction, create a new one if none exists. (Method 2 executes in existing transaction of 'parent 'method 1)
//    @Transactional(propagation = Propagation.REQUIRES_NEW) // Create a new transaction, and suspend the current transaction if one exists.
//    @Transactional(propagation = Propagation.NESTED) // Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise.

//    @Transactional(propagation = Propagation.MANDATORY) // Support a current transaction, throw an exception if none exists.
//    @Transactional(propagation = Propagation.NEVER) // Execute non-transactionally, throw an exception if a transaction exists.
//    @Transactional(propagation = Propagation.NOT_SUPPORTED) // Execute non-transactionally, suspend the current transaction if one exists.
//    @Transactional(propagation = Propagation.SUPPORTS) // Support a current transaction, execute non-transactionally if none exists.

//    NOTE: Actual transaction suspension will not work out-of-the-box on all transaction managers.
//    This in particular applies to JtaTransactionManager, which requires the jakarta.transaction.TransactionManager to be made available to it
//    (which is server-specific in standard Jakarta EE).
//    See Also: JtaTransactionManager.setTransactionManager(jakarta.transaction.TransactionManager)

    public StudentSettings updateStudentSettings(Student student) {
        StudentSettings ss = studentSettingsRepository.findAllByStudentId(student.getId());
        if (ss == null) return null;
        ss.setCreateDate(LocalDateTime.now());
        return studentSettingsRepository.save(ss);
    }

    private void throwTestException(Student student) {
        if (student.getId().equals(1L)) {
            throw new RuntimeException("For test");
        }
    }

}
