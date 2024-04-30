package com.example.book.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.bookmodel;
import com.example.book.service.bookservice;

import lombok.NonNull;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private bookservice books1;

    @PostMapping("/createBook")
    public ResponseEntity<bookmodel> createBook(@NonNull @RequestBody bookmodel book) {
        bookmodel createdBook = books1.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/readBook/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Optional<bookmodel> book = books1.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/readBooks")
    public ResponseEntity<List<bookmodel>> getAllBooks() {
        List<bookmodel> books = books1.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.ALREADY_REPORTED);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<bookmodel> updateBook(@NonNull @PathVariable int id, @RequestBody bookmodel updateRequest) {
        bookmodel updated = books1.updateBook(id, updateRequest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> removeBook(@NonNull @PathVariable int id) {
        books1.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
