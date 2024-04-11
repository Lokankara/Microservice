package com.stack.automation.company.dao.memory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryBankRepositoryTest {

    private final String id = "1";
    private final double newBalance = 1500;
    private final double initialBalance = 1000;
    private InMemoryBankRepository bankRepository;

    @BeforeEach
    public void setUp() {
        Map<String, Double> accountBalances = new HashMap<>();
        bankRepository = new InMemoryBankRepository(accountBalances);
    }

    @Test
    @DisplayName("Add new account with initial balance")
    void addNewAccountWithInitialBalance() {

        bankRepository.addAccount(id, initialBalance);

        assertEquals(initialBalance, bankRepository.getBalance(id));
    }

    @Test
    @DisplayName("Throw exception when adding duplicate account")
    void throwExceptionWhenAddingDuplicateAccount() {

        bankRepository.addAccount(id, initialBalance);

        assertThrows(IllegalArgumentException.class, () -> {
            bankRepository.addAccount(id, initialBalance);
        });
    }

    @Test
    @DisplayName("Update account balance")
    void updateAccountBalance() {

        bankRepository.addAccount(id, initialBalance);
        bankRepository.updateBalance(id, newBalance);

        assertEquals(newBalance, bankRepository.getBalance(id));
    }

    @Test
    @DisplayName("Throw exception when updating balance of non-existent account")
    void throwExceptionWhenUpdatingBalanceOfNonExistentAccount() {

        assertThrows(IllegalArgumentException.class,
                     () -> bankRepository.updateBalance(id, newBalance));
    }

    @Test
    @DisplayName("Check if account exists")
    void checkIfAccountExists() {

        bankRepository.addAccount(id, initialBalance);
        boolean exists = bankRepository.accountExists(id);

        assertTrue(exists);
    }

    @Test
    @DisplayName("Check if account does not exist")
    void checkIfAccountDoesNotExist() {

        boolean exists = bankRepository.accountExists(id);

        assertFalse(exists);
    }
}
