package com.ju.library_ddd.catalog.infrastructure;

import com.ju.library_ddd.catalog.application.BookInformation;
import com.ju.library_ddd.catalog.application.IsbnSearchService;
import com.ju.library_ddd.catalog.domain.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
 class BookSearchService implements IsbnSearchService {
    private final RestClient restClient;


    public BookSearchService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://openlibrary.org/")
                .build();
    }

    public BookInformation search(Isbn isbn){
        OpenLibraryIsbnSearchResult result =  restClient.get().uri("isbn/{isbn}.json", isbn.value())
                .retrieve()
                .body(OpenLibraryIsbnSearchResult.class);
        assert result != null;
        return new BookInformation(result.title());
    }
}
