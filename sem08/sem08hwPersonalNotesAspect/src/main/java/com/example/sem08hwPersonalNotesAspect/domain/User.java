package com.example.sem08hwPersonalNotesAspect.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс пользователя с id, именем.
 * id пользователя генерируется автоматически.
 * Имя передается в конструктор.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String userName;

    public User(String name) {
        this.userName = name;
    }

}
