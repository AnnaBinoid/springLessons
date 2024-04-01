package com.example.sem06task02.controller;

import com.example.sem06task02.domain.Reader;
import com.example.sem06task02.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepo;

    @GetMapping
    public List<Reader> getAll(){
        return readerRepo.findAll();
    }

    @PostMapping
    public Reader createReader(Reader reader){
        return readerRepo.save(reader);
    }
}
