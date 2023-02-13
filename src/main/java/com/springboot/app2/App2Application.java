package com.springboot.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {"domain"})
@EntityScan(basePackages = {"com.springboot.app2.entity"})

//@EnableJpaRepositories
public class App2Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}

}
