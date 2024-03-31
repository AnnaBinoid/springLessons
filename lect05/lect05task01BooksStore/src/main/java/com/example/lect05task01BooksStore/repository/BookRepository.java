package com.example.lect05task01BooksStore.repository;

import com.example.lect05task01BooksStore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{

}
