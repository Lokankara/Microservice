package com.stack.automation.company.dao;

public interface BankRepository {
    void addAccount(String id, double initialBalance);

    double getBalance(String id);

    void updateBalance(String id, double newBalance);

    boolean accountExists(String id);
}
