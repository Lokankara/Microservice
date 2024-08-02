package com.stack.service;

import com.stack.model.BankAccount;
import java.security.Principal;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

public class BankAccountServiceProxy implements BankAccountService {

    final BankAccountService delegate;

    public BankAccountServiceProxy(BankAccountService delegate) {
        this.delegate = delegate;
    }

    @Override
    public BankAccount findById(int id) {
        BankAccount result = delegate.findById(id);
        Principal principal = SecurityContextHolder.getContext().getAuthentication();


        if (!result.owner().equals(principal.getName())) {
            throw new AuthorizationDeniedException("Denied", new AuthorizationDecision(false));
        }
        return result;
    }

    @Override
    public BankAccount getById(int id) {
        return delegate.getById(id);
    }
}