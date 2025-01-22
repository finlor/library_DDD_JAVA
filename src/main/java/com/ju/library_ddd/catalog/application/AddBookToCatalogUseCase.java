package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.Book;
import com.ju.library_ddd.catalog.domain.BookRepository;
import com.ju.library_ddd.catalog.domain.Isbn;

@Usecase
public class AddBookToCatalogUseCase {

    private final BookRepository bookRepository;
    private final IsbnSearchService bookSearchService;

    public AddBookToCatalogUseCase(IsbnSearchService bookSearchService, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookSearchService = bookSearchService;
    }

    public void execute(Isbn isbn) {
        BookInformation searchResult = bookSearchService.search(isbn);
        Book book = new Book(searchResult.title(), isbn);
        bookRepository.save(book);

    }

}
