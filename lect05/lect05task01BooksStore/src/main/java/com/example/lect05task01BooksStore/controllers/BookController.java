package com.example.lect05task01BooksStore.controllers;

import com.example.lect05task01BooksStore.domain.Book;
import com.example.lect05task01BooksStore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    //обертка над классом, позволяющая задать парамтеры для ответа
    //если книга не найдена - чтобы мы могли задать код ошибки,
    // чтобы могли задать доп. параметры ответа.
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Optional<Book> book= bookService.findBy(id);
        // метод map у Optional. Если все хорошо
        // - нужно вернуть книгу в методе ok.
        // если нет - вернуть ошибку 404 Not found
        // если бы мы этого не сделали - была бы ошибка 500
        return book.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    /**
     * Метод обновления книги.
     * @param book книга для обновления.
     * @param id пользователь вряд ли будет знать Id
     *           в этом случае мы устанавливаем книге
     *           id, запрошенный пользователем.
     * @return
     */
    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id){
        book.setId(id);
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
