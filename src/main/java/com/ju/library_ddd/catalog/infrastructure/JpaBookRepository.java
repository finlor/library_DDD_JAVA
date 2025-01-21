package com.ju.library_ddd.catalog.infrastructure;

import com.ju.library_ddd.catalog.domain.Book;
import com.ju.library_ddd.catalog.domain.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaBookRepository implements BookRepository {

    private final BookEntityRepository bookEntityRepository;

    public JpaBookRepository(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public Book save(Book book){
        BookEntity bookEntity =new BookEntity(book.getId().id(), book.getTitle(), book.getIsbn().value());
        bookEntityRepository.save(bookEntity);
        return book;
    };
}
