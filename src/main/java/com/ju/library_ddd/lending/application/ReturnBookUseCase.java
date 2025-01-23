package com.ju.library_ddd.lending.application;

import com.ju.library_ddd.lending.domain.*;

@Usecase
public class ReturnBookUseCase {

    private final LoanRepository loanRepository;

    public ReturnBookUseCase(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void execute(LoanId loanId) {
        Loan loan = loanRepository.findByLoanIdOrThrow(loanId);
        loan.returned();
    }
}
