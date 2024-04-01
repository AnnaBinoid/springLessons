package com.example.sem06task02.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
