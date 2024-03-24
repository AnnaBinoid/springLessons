package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    /**
     * Метод выводит информацию о создании нового пользователя
     * @param user
     */
    public void notifyUser(User user)
    {
        System.out.println("A new user has been created: " + user.getName());
    }

}
