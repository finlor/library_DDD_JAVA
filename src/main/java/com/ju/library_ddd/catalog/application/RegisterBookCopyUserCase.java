package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.BarCode;
import com.ju.library_ddd.catalog.domain.BookId;
import com.ju.library_ddd.catalog.domain.Copy;
import com.ju.library_ddd.catalog.domain.CopyRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterBookCopyUserCase {

    private final CopyRepository copyRepository;


    public RegisterBookCopyUserCase(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public void register(BookId bookId, BarCode barCode) {
        copyRepository.save(new Copy(barCode, bookId));
    }
}
