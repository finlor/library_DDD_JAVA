package com.ju.library_ddd.catalog.domain;


import org.springframework.util.Assert;

public class Book {
    private BookId id;
    private String title;
    private Isbn isbn;


    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "Title must not be null");
        Assert.notNull(isbn, "Isbn must not be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }

}
