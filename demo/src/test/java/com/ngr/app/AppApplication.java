package com.ngr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
        System.setProperty("spring.config.location", "/home/ayman-aomari/Desktop/ngrBackend/app/demo/src/main/resources/application.properties");

		SpringApplication.run(AppApplication.class, args);
	}

}