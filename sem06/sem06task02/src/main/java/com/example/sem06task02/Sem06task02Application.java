package com.example.sem06task02;

// Создать Rest API на базе Spring Boot
// для управления библиотекой.
// Читатель и книга - сущности.
// Одна книга может быть взята одним читателем
// Один читатель может взять несколько книг.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sem06task02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sem06task02Application.class, args);
	}

}
