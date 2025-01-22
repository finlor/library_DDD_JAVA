package com.ju.library_ddd.catalog.application;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
@Validated
public @interface Usecase {
}
