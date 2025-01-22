package com.ju.library_ddd.lending.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record UserId (UUID id) {

    public UserId {
        Assert.notNull(id, "User id cannot be null");
    }
    public UserId(){
        this(UUID.randomUUID());
    }
}
