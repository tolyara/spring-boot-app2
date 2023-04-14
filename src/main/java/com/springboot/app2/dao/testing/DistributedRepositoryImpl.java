package com.springboot.app2.dao.testing;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//@NoRepositoryBean
//public class DistributedRepositoryImpl<ENTITY> extends SimpleJpaRepository<ENTITY, Long> implements DistributedRepository<ENTITY> {
//
//    public DistributedRepositoryImpl(JpaEntityInformation<ENTITY, ?> entityInformation, EntityManager entityManager) {
//        super(entityInformation, entityManager);
//    }
//
//}

public abstract class DistributedRepositoryImpl<ENTITY> implements DistributedRepository<ENTITY> {
}
