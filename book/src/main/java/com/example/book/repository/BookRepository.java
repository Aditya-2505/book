package com.example.book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.book.model.bookmodel;
public interface BookRepository extends JpaRepository<bookmodel, Integer> {
    Optional<bookmodel> findById(int id);
}
