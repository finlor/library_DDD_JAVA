package com.ju.library_ddd.lending.domain;

import jakarta.persistence.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Loan extends AbstractAggregateRoot<Loan> {

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

    public Loan(CopyId copyId, UserId userId, LoanRepository loanRepository) {
        Assert.notNull(copyId, "copyId must not be null");
        Assert.notNull(userId, "userId must not be null");
        //super idee, on injecte le repository ici et ensuite on s assure que la copy est disponible dans le domain au lieu de le faire dans l'application layer
        Assert.isTrue(loanRepository.isAvailable(copyId), "loanRepository is available" );
        this.loanId = new LoanId();
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.expectedReturned = LocalDate.now().plusDays(15);

        // This is because we extend from AbstractAggregateRoot, which has those methods to register events.
        // And the event is registered, but it will only be fired when we hit save on the repository.
        this.registerEvent(new LoanCreated(this.copyId));
    }

    public void returned() {
        this.returnedAt = LocalDateTime.now();
        this.registerEvent(new LoanClosed(this.copyId));
    }
}
