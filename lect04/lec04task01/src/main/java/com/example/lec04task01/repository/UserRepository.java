package com.example.lec04task01.repository;

import com.example.lec04task01.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Осуществляет хранение данных
 */
@Component
public class UserRepository {
    /**
     * Экземпляр класса ConcurrentHashMap
     * для хранения данных пользователей.
     */
    private Map<Long, User> users = new ConcurrentHashMap<>();

    /**
     * Счетчик, который хранит значение id последнего пользователя.
     * Для каждого следующего пользователя увеличивается на 1.
     * Используем AtomicLong во избежание конфликтов при многопоточности.
     */
    private AtomicLong counter = new AtomicLong();

    /**
     * Метод для возвращения всех пользователей по значениям Map
     */
    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    /**
     * Метод ищет пользователя по id
     * @param id - для поиска пользователя
     * @return user - пользователь с искомым id
     */
    public User findById(Long id){
        return users.get(id);
    }

    /**
     * Метод присваивает пользователю id
     * и сохраняет пользователя в репозиторий (в данном случае в Map)
     * @param user - пользователь, которого необходимо сохранить
     * @return user - сохраненный пользователь.
     */
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }

}
