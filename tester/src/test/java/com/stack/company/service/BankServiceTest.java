package com.stack.company.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    EmployeeService employeeService = Mockito.mock(EmployeeService.class);

    BankService bankService = new BankServiceManager();

    @Test
    void testPay() {
//        Mockito.when()
    }
}
