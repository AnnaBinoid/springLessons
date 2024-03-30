package com.example.spring_data_example01.domain;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 */
@Data
@Entity //
@Table(name = "books") //даем спрингу понять, что это таблица с именем 'books'
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;

    @Column( name = "publication_year", nullable = true)
    private Integer publicationYear;
}
