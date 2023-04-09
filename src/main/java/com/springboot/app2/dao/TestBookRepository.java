package com.springboot.app2.dao;

import com.springboot.app2.entity.fortest.TestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBookRepository extends JpaRepository<TestBook, Long> {
}
