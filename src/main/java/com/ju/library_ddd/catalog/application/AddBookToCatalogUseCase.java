package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.Book;
import com.ju.library_ddd.catalog.domain.BookRepository;
import com.ju.library_ddd.catalog.domain.Isbn;
import com.ju.library_ddd.catalog.infrastructure.BookSearchService;
import com.ju.library_ddd.catalog.infrastructure.OpenLibraryIsbnSearchResult;
import org.springframework.stereotype.Service;

@Service
public class AddBookToCatalogUseCase {

    private final BookRepository bookRepository;
    private final BookSearchService bookSearchService;

    public AddBookToCatalogUseCase(BookSearchService bookSearchService, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookSearchService = bookSearchService;
    }

    public void execute(Isbn isbn) {
        OpenLibraryIsbnSearchResult searchResult = bookSearchService.search(isbn);
        Book book = new Book(searchResult.title(), isbn);
        bookRepository.save(book);
    }

}
