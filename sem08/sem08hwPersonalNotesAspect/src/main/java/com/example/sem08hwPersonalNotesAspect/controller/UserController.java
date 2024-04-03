package com.example.sem08hwPersonalNotesAspect.controller;

import com.example.sem08hwPersonalNotesAspect.domain.User;
import com.example.sem08hwPersonalNotesAspect.services.iUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final iUserService iUserService;

    /**
     * Обработчик запроса на получение всех пользователей
     * @return Лист всех пользователей.
     */
    @GetMapping
    public List<User> getAll(){
        return iUserService.getAllUsers();
    }

    /**
     * Обработчик запроса на создание пользователя по телу запроса.
     * @param user - объект класса пользователь, заданный в теле HTTP-запроса.
     * @return - созданного пользователя.
     */
    @PostMapping
    public User createUser(@RequestBody User user){
        return iUserService.createUser(user);
    }

    /**
     * Получение пользователя по Id.
     * @param id - id искомого пользователя.
     * @return - объект класса пользователь по заданному id.
     */
    @GetMapping("{user_id}")
    public ResponseEntity<User> getUser(@PathVariable("user_id")Long id){
        User userById;
        try {
            userById = iUserService.getUserById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new User(null));
        }
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }
}
