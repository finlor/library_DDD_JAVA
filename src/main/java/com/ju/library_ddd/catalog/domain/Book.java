package com.ju.library_ddd.catalog.domain;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;
import java.util.Objects;

@Entity
public class Book {
    @EmbeddedId
    private BookId id;
    private String title;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "isbn"))
    private Isbn isbn;


    public Book(String title, Isbn isbn) {
        Assert.notNull(title, "Title must not be null");
        Assert.notNull(isbn, "Isbn must not be null");
        this.id = new BookId();
        this.title = title;
        this.isbn = isbn;
    }

    public Book() {

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
