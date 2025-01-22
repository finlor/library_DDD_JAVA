package com.ju.library_ddd.lending.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record LoanId(UUID id) {

    public LoanId {
        Assert.notNull(id, "loan id cannot be null");
    }
    public LoanId(){
        this(UUID.randomUUID());
    }

}
