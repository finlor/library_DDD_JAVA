package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.BarCode;
import com.ju.library_ddd.catalog.domain.BookId;
import com.ju.library_ddd.catalog.domain.Copy;
import com.ju.library_ddd.catalog.domain.CopyRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Usecase
public class RegisterBookCopyUserCase {

    private final CopyRepository copyRepository;


    public RegisterBookCopyUserCase(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    public void register(@NotNull BookId bookId, @NotNull BarCode barCode) {
        copyRepository.save(new Copy(barCode, bookId));
    }
}
