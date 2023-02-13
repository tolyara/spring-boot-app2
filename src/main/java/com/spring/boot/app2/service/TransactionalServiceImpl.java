package com.spring.boot.app2.service;

import com.spring.boot.app2.dao.StudentRepository;
import com.spring.boot.app2.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class TransactionalServiceImpl implements TransactionalService {

    private final StudentRepository studentRepository;

    public TransactionalServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student updateStudent() {
        Student student = new Student();
        Student s = studentRepository.save(student);
        s.setName("Stud-" + s.getId());
        return studentRepository.save(s);
    }

}
