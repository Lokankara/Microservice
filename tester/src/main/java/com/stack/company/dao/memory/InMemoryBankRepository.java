package com.stack.company.dao.memory;

import com.stack.company.dao.BankRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class InMemoryBankRepository implements BankRepository {

    private final Map<String, Double> accountBalances;

    @Override
    public void addAccount(String id, double initialBalance) {
        if (!accountExists(id)) {
            accountBalances.put(id, initialBalance);
        } else {
            throw new IllegalArgumentException(
                    "Account with ID %s already exists.".formatted(id));
        }
    }

    @Override
    public double getBalance(String id) {
        if (accountExists(id)) {
            return accountBalances.get(id);
        } else {
            throw new IllegalArgumentException(
                    "Account with ID %s does not exist.".formatted(id));
        }
    }

    @Override
    public void updateBalance(String id, double newBalance) {
        if (accountExists(id)) {
            accountBalances.put(id, newBalance);
        } else {
            throw new IllegalArgumentException(
                    "Account with ID %s does not exist.".formatted(id));
        }
    }

    @Override
    public boolean accountExists(String id) {
        return accountBalances.containsKey(id);
    }
}
