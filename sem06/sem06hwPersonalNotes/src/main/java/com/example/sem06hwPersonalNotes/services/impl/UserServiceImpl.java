package com.example.sem06hwPersonalNotes.services.impl;

import com.example.sem06hwPersonalNotes.domain.Note;
import com.example.sem06hwPersonalNotes.domain.User;
import com.example.sem06hwPersonalNotes.repository.iUserRepository;
import com.example.sem06hwPersonalNotes.services.iUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Класс содержит бизнес-логику сервиса пользователей.
 * Имплементирует интерфейс iUserService
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements iUserService {

    /**
     * Внедрение в класс пользователя UserServiceImpl
     * зависимости от интерфейса iUserServiceImpl.
     */
    private final iUserRepository iUserRepository;

    /**
     * Список всех пользователей.
     * @return список пользователей.
     */
    public List<User> getAllUsers(){
        return iUserRepository.findAll();
    }

    /**
     * Создание нового пользователя.
     * @param user - экземпляр пользователя класса User.
     * @return запись в репозиторий.
     */
    public User createUser(User user) {

        return iUserRepository.save(user);
    }

    /**
     * Получение пользователя по id.
     * @param id - id искомого пользователя.
     * @return в случае успеха - найденного пользователя
     * , в противном случае - null
     */
    public User getUserById(Long id){
        return iUserRepository.findById(id)
                .orElseThrow(null);
    }



}
