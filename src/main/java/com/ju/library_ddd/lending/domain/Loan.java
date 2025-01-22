package com.ju.library_ddd.lending.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Loan {

    @EmbeddedId
    private LoanId loanId;
    @Embedded
    @AttributeOverride(name= "id", column = @Column(name = "copy_id"))
    private CopyId copyId;
    @Embedded
    @AttributeOverride(name= "id", column = @Column(name = "user_id"))
    private UserId userId;
    private LocalDateTime createdAt;
    private LocalDate expectedReturned;
    private LocalDateTime returnedAt;

    private Long version;

    public Loan() {}

    public Loan(CopyId copyId, UserId userId) {
        this.loanId = new LoanId();
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.expectedReturned = LocalDate.now().plusDays(15);
    }

    public void returned() {
        this.returnedAt = LocalDateTime.now();
    }
}
