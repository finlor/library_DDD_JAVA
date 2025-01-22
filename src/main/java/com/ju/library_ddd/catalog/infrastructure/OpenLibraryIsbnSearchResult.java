package com.ju.library_ddd.catalog.infrastructure;

import java.util.List;

public record OpenLibraryIsbnSearchResult(List<String> publishers,
                                          String title,
                                          List<String> isbn_13,
                                          int revisions) {
}
