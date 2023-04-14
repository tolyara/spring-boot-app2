package com.springboot.app2.config.testing;

import com.springboot.app2.dao.testing.DistributedRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(value = "com.springboot.app2.dao.testing", repositoryBaseClass = DistributedRepositoryImpl.class)
public class TestingConfig {
}
