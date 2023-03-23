package com.springboot.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/*
	SystemProperties.get("java.version") -> 19.0.2
	SpringVersion.getVersion() -> 6.0.4
 */

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class	// disable security
})
@EntityScan(basePackages = {"com.springboot.app2.entity"})
@ServletComponentScan
@EnableAsync // for @Async feature, some executor will be supplied by Spring if we don't create custom executor by ourselves
public class App2Application {
	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
}

// TODO list
// Spring Cloud
// Reddis

