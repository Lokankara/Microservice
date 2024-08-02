package com.stack.service;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class BankAccountServiceTest {
//    BankAccountService bank = (BankAccountService) AuthorizationAdvisorProxyFactory.withDefaults().proxy(new DefaultBankAccountService());

    @Autowired
    BankAccountService bank;

    @Test
    void findByIdHolder() {
        SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken("paul", "root", "ROLE_USER"));
        bank.findById(1);
    }

    @Test
    @WithMockUser("paul")
    void findById() {
        bank.findById(1);
    }

    @Test
    @WithMockUser(username = "sam", roles = "admin")
    void findByIdWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class).isThrownBy(() -> bank.findById(1));
    }

    @Test
    @WithMockUser("paul")
    void getById() {
        bank.getById(1);
    }

    @Test
    @WithMockUser(username = "bob", roles = "USER")
    void getByIdWhenAccount() {
        bank.getById(1);
    }

    @Test
    @WithMockUser(username = "bob", roles = "USER")
    void findByIdWhenAccount() {
        bank.findById(1);
    }

//    @Test
    @WithMockUser(username = "bob", roles = "USER")
    void findByIdWhenAccountNumber() {
        assertThatExceptionOfType(AuthorizationDeniedException.class).isThrownBy(() -> bank.getById(1).accountNumber());
    }

    @Test
    @WithMockUser(username = "bob", roles = "USER")
    void findByIdWhenAccountNumberWithMask() {
        assertThat(bank.findById(1).accountNumber()).isEqualTo("****");
    }

    @Test
    @WithMockUser(username = "sam", roles = "admin")
    void getByIdWhenDenied() {
        assertThatExceptionOfType(AuthorizationDeniedException.class).isThrownBy(() -> bank.getById(1));
    }
}
