package com.springboot.app2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSettingsRepository extends JpaRepository<com.springboot.app2.entity.StudentSettings, Long> {
}
