package com.example.lec04task01.services;

import com.example.lec04task01.domain.User;
import com.example.lec04task01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    /**
     * Экземпляр класса репозитория пользователей.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Возвращает для пользователя список пользователей
     * @return список пользователей
     */
    public List<User> getAllUsers(){
        userRepository.save(new User(null, "Ann", "1@ex"));
        userRepository.save(new User(null, "Bob", "2@ex"));
        userRepository.save(new User(null, "Dilan", "3@ex"));
        return userRepository.findAll();
    }

    /**
     * Возвращает пользователя по заданному id
     * @param id - введенный пользователем id для поиска
     * @return user - пользователь с искомым id
     */
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
