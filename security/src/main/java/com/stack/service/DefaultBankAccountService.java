package com.stack.service;

import com.stack.model.BankAccount;


public class DefaultBankAccountService implements BankAccountService {
    @Override
    public BankAccount findById(int id) {
        return new BankAccount(id, "paul", "1234567890", 54321);
//        AuthorizationProxyFactory factory = AuthorizationAdvisorProxyFactory.withDefaults();
//        return (BankAccount) factory.proxy(account);
    }

    public BankAccount getById(int id) {
        return findById(id);
    }
}
