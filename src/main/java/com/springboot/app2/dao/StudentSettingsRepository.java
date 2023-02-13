package com.springboot.app2.dao;

import com.springboot.app2.entity.StudentSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSettingsRepository extends JpaRepository<StudentSettings, Long> {

    public StudentSettings findAllByStudentId(Long studentId);

}
