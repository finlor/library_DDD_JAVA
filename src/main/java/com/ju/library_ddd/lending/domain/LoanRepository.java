package com.ju.library_ddd.lending.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository  extends CrudRepository<Loan, LoanId> {

    @Query("select count(*) = 0 from Loan WHERE copyId = :id and returnedAt is null")
    boolean isAvailable(CopyId id);

    public default Loan findByLoanIdOrThrow(LoanId loanId){
        return findById(loanId).orElseThrow(()->new RuntimeException("loan not found"));
    };
}
