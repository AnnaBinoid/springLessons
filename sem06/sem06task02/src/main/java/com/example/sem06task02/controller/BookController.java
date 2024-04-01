package com.example.sem06task02.controller;


import com.example.sem06task02.domain.Book;
import com.example.sem06task02.domain.Reader;
import com.example.sem06task02.repository.BookRepository;
import com.example.sem06task02.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {
    private final BookRepository bookRepo;
    private final ReaderRepository readerRepo;

    @PostMapping
    public Book createBook(@RequestBody Book book) {

        return bookRepo.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable("id") Long id) {

        return bookRepo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}/reader/{readerId}")
    public ResponseEntity<Book> assignReaderToBook(@PathVariable Long id, @PathVariable Long readerId) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        Optional<Reader> readerOptional = readerRepo.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book = bookOptional.get();
            Reader reader = readerOptional.get();
            book.setReader(reader);
            bookRepo.save(book);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            bookRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}