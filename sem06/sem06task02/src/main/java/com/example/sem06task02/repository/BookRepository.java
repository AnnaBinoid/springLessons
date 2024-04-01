package com.example.sem06task02.repository;

import com.example.sem06task02.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс обеспечивает архитектурную границу
 * между репозиторием и контроллером. Задает гибкую связь,
 * благодаря которой можно менять реализацию репозитория,
 * что не отразится на контроллере.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
