package com.springboot.app2.dao.testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

//@NoRepositoryBean
//public interface DistributedRepository<ENTITY> extends JpaRepository<ENTITY, Long> {
//}

public interface DistributedRepository<ENTITY> {

    ENTITY save(ENTITY entity);
    Optional<ENTITY> findById(Long id);

}