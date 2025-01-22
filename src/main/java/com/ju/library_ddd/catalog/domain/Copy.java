package com.ju.library_ddd.catalog.domain;

import jakarta.persistence.*;
import org.springframework.util.Assert;

@Entity
public class Copy {
    @EmbeddedId
    private CopyId id;
    @Embedded
    private BarCode barCode;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "book_id"))
    private BookId bookId;

    public Copy(BarCode barCode, BookId bookId) {
        Assert.notNull(barCode, "barCode must not be null");
        Assert.notNull(bookId, "bookId must not be null");
        this.id = new CopyId();
        this.barCode = barCode;
        this.bookId = bookId;
    }

    public Copy() {

    }
}