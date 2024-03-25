package com.example.sem04hometask.services;

import com.example.sem04hometask.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    /**
     * список пользователей, примитивная база данных
     */
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }

}
