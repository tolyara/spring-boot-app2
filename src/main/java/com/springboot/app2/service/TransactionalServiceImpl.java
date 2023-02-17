package com.springboot.app2.service;

import com.springboot.app2.dao.StudentRepository;
import com.springboot.app2.dao.StudentSettingsRepository;
import com.springboot.app2.entity.Student;
import com.springboot.app2.entity.StudentSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;

@Service
public class TransactionalServiceImpl implements TransactionalService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StudentRepository studentRepository;
    private final StudentSettingsRepository studentSettingsRepository;

    public TransactionalServiceImpl(StudentRepository studentRepository, StudentSettingsRepository studentSettingsRepository) {
        this.studentRepository = studentRepository;
        this.studentSettingsRepository = studentSettingsRepository;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
//        Student newStudent1 = new Student();
//        newStudent1 = studentRepository.save(newStudent1);
//        newStudent1.setName("stud-" + newStudent1.getId());
//        studentRepository.save(newStudent1);

        Student existing = studentRepository.findById(student.getId()).get();
        existing.setName(student.getName());
        existing.setGrade(student.getGrade());
        existing = studentRepository.save(existing);

        updateStudentSettings(existing);
        return existing;
    }

//    @Transactional // REQUIRED by default, Support a current transaction, create a new one if none exists. (Method 2 executes in existing transaction of 'parent 'method 1)
//    @Transactional(propagation = Propagation.REQUIRES_NEW) // Create a new transaction, and suspend the current transaction if one exists.
//    @Transactional(propagation = Propagation.NESTED) // Execute within a nested transaction if a current transaction exists, behave like REQUIRED otherwise.

//    @Transactional(propagation = Propagation.MANDATORY) // Support a current transaction, throw an exception if none exists.
    @Transactional(propagation = Propagation.NEVER) // Execute non-transactionally, throw an exception if a transaction exists.
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

}
