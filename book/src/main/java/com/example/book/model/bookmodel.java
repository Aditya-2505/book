package com.example.book.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="Book")
public class bookmodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookId;
    private String BookAuthorName;
    private String BookName;
    private float Rating;
    private int price;
    public int getBookId() {
        return BookId;
    }
    public void setBookId(int bookId) {
        BookId = bookId;
    }
    public String getBookAuthorName() {
        return BookAuthorName;
    }
    public void setBookAuthorName(String bookAuthorName) {
        BookAuthorName = bookAuthorName;
    }
    public String getBookName() {
        return BookName;
    }
    public void setBookName(String bookName) {
        BookName = bookName;
    }
    public float getRating() {
        return Rating;
    }
    public void setRating(float rating) {
        Rating = rating;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public bookmodel(int bookId, String bookAuthorName, String bookName, float rating, int price) {
        BookId = bookId;
        BookAuthorName = bookAuthorName;
        BookName = bookName;
        Rating = rating;
        this.price = price;
    }
    public bookmodel() {
    }


    
    
}
