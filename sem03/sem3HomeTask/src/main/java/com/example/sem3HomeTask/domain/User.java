package com.example.sem3HomeTask.domain;

/**
 * Класс данных, описывающий логику работы пользователя
 */

// User никогда не будет компонентом
public class User {
    private String name;

    private int age;

    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}