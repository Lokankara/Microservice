package com.stack.model;

import com.stack.service.MaskMethodAuthorizationDeniedHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

public class BankAccount {
    private final int id;
    private final String owner;
    private final String accountNumber;
    private final double balance;

    public BankAccount(int id, String owner, String accountNumber, double balance) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int id() {
        return id;
    }

    public String owner() {
        return owner;
    }

    @PreAuthorize("this.owner == authentication?.name")
    @HandleAuthorizationDenied(handlerClass = MaskMethodAuthorizationDeniedHandler.class)
    public String accountNumber() {
        return accountNumber;
    }

    public double balance() {
        return balance;
    }
}
