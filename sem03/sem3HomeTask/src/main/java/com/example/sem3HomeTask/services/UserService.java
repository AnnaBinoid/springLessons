package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Позволяет создать нового пользователя и известить об этом
 */
@Service
public class UserService {

    private NotificationService notificationService;

    // Внедрение зависимости через конструктор
    // Если бы конструктора не было, то в приватном поле notificationService
    // нужна была бы аннотация @Autowired, чтобы положить экземпляр класса в контейнер
    // для автозаполнения
    public UserService(NotificationService notificationService)
    {

        this.notificationService = notificationService;
    }

    /**
     * Метод создает нового пользователя, устанавливая перечисленные параметры
     * и выводит сообщение о создании нового пользователя.
     * @param name - имя пользователя
     * @param age - возраст пользователя
     * @param email - e-mail пользователя
     * @return user - новый пользователь
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }

}
