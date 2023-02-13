package com.springboot.app2.dao;

//import com.spring.boot.app2.entity.domain.Student;
import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
