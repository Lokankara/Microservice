package com.stack.automation.company.service;

import com.stack.automation.company.dao.BankRepository;
import com.stack.automation.company.dao.EmployeeRepository;
import com.stack.automation.company.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class BankAccountServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private BankRepository bankRepository;
    private BankAccountService bankService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    public void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", 1000));
        employees.add(new Employee("2",  2000));
        Mockito.when(employeeRepository.findById("1")).thenReturn(Optional.of(employees.get(0)));
        Mockito.when(employeeRepository.findById("3")).thenReturn(Optional.empty());
        bankService = new BankAccountService(employeeRepository, bankRepository);
    }

    @AfterEach
    void afterAll() throws Exception {
        autoCloseable.close();
    }

    @Test
    @DisplayName("Payment succeeds when employee found")
    void paymentSucceedsWhenEmployeeFound() {
        String id = "1";
        double salary = 1500;
        bankService.pay(id, salary);

        Mockito.verify(bankRepository).addAccount(id, salary);
    }

    @Test
    @DisplayName("Payment fails when employee not found")
    void paymentFailsWhenEmployeeNotFound() {
        String id = "3";
        double salary = 1500;
        bankService.pay(id, salary);

        Mockito.verify(bankRepository, Mockito.never()).addAccount(id, salary);
    }
}
