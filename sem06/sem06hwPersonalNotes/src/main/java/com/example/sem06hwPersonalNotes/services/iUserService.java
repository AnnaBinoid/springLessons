package com.example.sem06hwPersonalNotes.services;

import com.example.sem06hwPersonalNotes.domain.Note;
import com.example.sem06hwPersonalNotes.domain.User;

import java.util.List;

/**
 * Контракт о том, какие методы будет иметь сервис пользователей.
 * Интерфейс - архитектурная граница между сервисом и котроллерами.
 * Благодаря имплементации интерфейса можно будет делать разные
 * реализаци сервисов.
 */
public interface iUserService {


    List<User> getAllUsers();

    User createUser(User user);

    User getUserById(Long user_id);

}
