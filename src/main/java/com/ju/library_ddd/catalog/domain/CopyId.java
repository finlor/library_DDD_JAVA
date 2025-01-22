package com.ju.library_ddd.catalog.domain;

import org.springframework.util.Assert;

import java.util.UUID;

public record CopyId(UUID id) {

    public CopyId {
        Assert.notNull(id, "copy cannot be null");
    }

    public CopyId  (){
        this(UUID.randomUUID());
    }
}
