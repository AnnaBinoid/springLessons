package com.example.sem09hw01Eureca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sem09hw01EurecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem09hw01EurecaApplication.class, args);
	}

}
