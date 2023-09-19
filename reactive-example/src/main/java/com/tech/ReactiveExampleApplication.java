package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ReactiveExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveExampleApplication.class, args);
	}

}
