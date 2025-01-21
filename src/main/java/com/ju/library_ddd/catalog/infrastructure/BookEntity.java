package com.ju.library_ddd.catalog.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class BookEntity {

    @Id
    private UUID id;
    private String title;
    private String isbn;

    public BookEntity(){}

    public BookEntity(UUID id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }

}
