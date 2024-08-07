package com.stack.service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authorization.method.AuthorizeReturnObject;

@Retention(RetentionPolicy.RUNTIME)
@PostAuthorize("returnObject.owner == authentication?.name or hasRole('USER')")
@AuthorizeReturnObject
public @interface PostReadBankAccount {
}