package com.example.book.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.book.model.bookmodel;
import com.example.book.repository.BookRepository;

@Service
public class bookservice {

    @Autowired
    private BookRepository bookRepository;

    public bookmodel createBook(@NonNull bookmodel book) {
        return bookRepository.save(book);
    }

    public List<bookmodel> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<bookmodel> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public bookmodel updateBook(int id, bookmodel updatedBook) {
        return bookRepository.findById(id)
                .map(existingBook -> {
                    existingBook.setBookName(updatedBook.getBookName());
                    existingBook.setBookAuthorName(updatedBook.getBookAuthorName());
                    existingBook.setRating(updatedBook.getRating());
                    existingBook.setPrice(updatedBook.getPrice());
                    return bookRepository.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }
}

