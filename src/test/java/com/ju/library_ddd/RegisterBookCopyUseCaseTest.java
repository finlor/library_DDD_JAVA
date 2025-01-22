package com.ju.library_ddd;

import com.ju.library_ddd.catalog.application.RegisterBookCopyUserCase;
import com.ju.library_ddd.catalog.domain.BarCode;
import com.ju.library_ddd.catalog.domain.BookId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class RegisterBookCopyUseCaseTest {

    @Autowired
    RegisterBookCopyUserCase registerBookCopyUseCase;

    @Test
    public void test() {
        registerBookCopyUseCase.register(new BookId(UUID.randomUUID()), new BarCode("123"));
    }
}
