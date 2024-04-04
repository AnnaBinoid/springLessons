package com.example.sem09hw01CloudAPIgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Sem09hw01CloudApIgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem09hw01CloudApIgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("Task1",r->r.path("/notes/**")
						.uri("http://localhost:8081/")).build();}
}
