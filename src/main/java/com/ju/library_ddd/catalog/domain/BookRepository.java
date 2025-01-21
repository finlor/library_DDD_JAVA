package com.ju.library_ddd.catalog.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, BookId> {
}
