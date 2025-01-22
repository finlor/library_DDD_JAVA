package com.ju.library_ddd.lending.application;

import com.ju.library_ddd.catalog.application.Usecase;
import com.ju.library_ddd.lending.domain.CopyId;
import com.ju.library_ddd.lending.domain.Loan;
import com.ju.library_ddd.lending.domain.LoanRepository;
import com.ju.library_ddd.lending.domain.UserId;
import jakarta.validation.constraints.NotNull;

@Usecase
public class RentBookUseCase {

    private final LoanRepository loanRepository;

    public RentBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(@NotNull CopyId copyId, @NotNull UserId userId) {

        //TODO: verify the copy is not already rented
        loanRepository.save(new Loan(copyId, userId));
    }
}
