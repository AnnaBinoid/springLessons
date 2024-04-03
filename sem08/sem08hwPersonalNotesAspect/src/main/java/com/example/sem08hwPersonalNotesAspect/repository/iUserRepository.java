package com.example.sem08hwPersonalNotesAspect.repository;

import com.example.sem08hwPersonalNotesAspect.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * /**
 * Интерфейс репозитория заметок, наследуюемого от JPARepository.
 * Интерфейс обеспечивает архитектурную границу
 * между репозиторием и контроллером. Задает гибкую связь,
 * благодаря которой можно менять реализацию репозитория,
 * что не отразится на контроллере.
 */
@Repository
public interface iUserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
