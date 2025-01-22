package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.Isbn;

public interface IsbnSearchService {
    BookInformation search(Isbn isbn);
}
