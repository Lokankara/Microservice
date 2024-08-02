package com.stack.service;

import com.stack.model.BankAccount;

public interface BankAccountService {

    @PostReadBankAccount
    BankAccount findById(int id);

    @PostReadBankAccount
    BankAccount getById(int id);
}
