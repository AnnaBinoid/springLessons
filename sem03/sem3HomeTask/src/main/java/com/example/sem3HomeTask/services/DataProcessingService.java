package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Позволяет манипулировать данными пользователя
 */
@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод сортирует пользователей по возрасту
     * @param  users - список пользователей
     * @return users - отсортированный список пользователей
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод оставляет пользователей, старше заданного возраста
     * @param users - все пользователи
     * @param age - возраст для фильтрации
     * @return users - лист с отфильтрованными пользователями
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод, позволяющий вычислить средний возраст пользователей из
     * листа, подающегося на вход
     * @param users - список пользователей
     * @return int - средний возраст списка пользователей
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавляет пользователя в репозиторий класса UserRepository
     * @param user
     */
    public void addUserToList(User user) {
        repository.getUsers().add(user);
    }

}
