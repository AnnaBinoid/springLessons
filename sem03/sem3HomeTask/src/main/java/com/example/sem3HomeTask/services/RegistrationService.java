package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс для регистрации пользователя в БД
 */
@Service
public class RegistrationService {

    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    private UserService userService;

    private NotificationService notificationService;

    public RegistrationService(DataProcessingService dataProcessingService,
                               UserService userService,
                               NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    /**
     * Метод осуществляет создание пользователя через userService.createUser()
     * и добавление его в бд через dataProcessingService.addUserToList(user);
     * @param name
     * @param age
     * @param email
     * @return возвращает пользователя
     */
    public User processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        return user;
    }

}
