package com.springboot.app2.service;

import com.springboot.app2.dao.StudentRepository;
import com.springboot.app2.dao.StudentSettingsRepository;
import com.springboot.app2.entity.Student;
import com.springboot.app2.entity.StudentSettings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;

@Service
public class TransactionalServiceImpl implements TransactionalService {

    private final StudentRepository studentRepository;
    private final StudentSettingsRepository studentSettingsRepository;
//    private final PlatformTransactionManager transactionManager;
//    private final TransactionTemplate transactionTemplate;

    public TransactionalServiceImpl(StudentRepository studentRepository, StudentSettingsRepository studentSettingsRepository
//                                    PlatformTransactionManager transactionManager, TransactionTemplate transactionTemplate
    ) {
        this.studentRepository = studentRepository;
        this.studentSettingsRepository = studentSettingsRepository;
//        this.transactionManager = transactionManager;
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        Student newStudent1 = new Student();
        newStudent1 = studentRepository.save(newStudent1);
        newStudent1.setName("stud-" + newStudent1.getId());
        studentRepository.save(newStudent1);

        Student existing = studentRepository.findById(student.getId()).get();
        existing.setName(student.getName());
        existing.setGrade(student.getGrade());
        existing = studentRepository.save(existing);

        updateStudentSettings(existing);
        return existing;
    }

    @Transactional
    public StudentSettings updateStudentSettings(Student student) {
        StudentSettings ss = studentSettingsRepository.findAllByStudentId(student.getId());
        ss.setCreateDate(LocalDateTime.now());
        return studentSettingsRepository.save(ss);
    }

}
