package com.springboot.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/*
	SystemProperties.get("java.version") -> 19.0.2
	SpringVersion.getVersion() -> 6.0.4
 */

@SpringBootApplication
@EntityScan(basePackages = {"com.springboot.app2.entity"})
public class App2Application {
	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);
	}
}
