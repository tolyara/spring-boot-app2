package com.springboot.app2.service;

import com.springboot.app2.entity.Student;

public interface TransactionalService {

    Object updateStudent(Student student);

}
