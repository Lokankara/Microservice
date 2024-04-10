package com.stack.company.service;

import com.stack.company.dao.EmployeeRepository;
import com.stack.company.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class EmployeeManagerTest {

    @InjectMocks
    private EmployeeManager employeeManager;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private BankService bankService;

    private static AutoCloseable autoCloseable;

    @BeforeEach
    public void setup() {
        autoCloseable = openMocks(this);
    }

    @AfterEach
    void afterAll() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testPayment(){
        when(employeeRepository.findAll()).thenReturn(emptyList());
        assertThat(employeeManager.payEmployees()).isZero();
    }

    @Test
    void testPaymentArePresent(){
        when(employeeRepository.findAll()).thenReturn(asList(new Employee("1", 1000)));
        assertThat(employeeManager.payEmployees()).isEqualTo(1);
        verify(bankService).pay("1", 1000);
    }

    @Test
    @Disabled
    void testPaymentEmployeesWhenSeveralArePresent(){
        when(employeeRepository.findAll()).thenReturn(asList(new Employee("1", 1000)));
        assertThat(employeeManager.payEmployees()).isEqualTo(1);
        verify(bankService).pay("1", 1000);
        verify(bankService).pay("2", 1000);
    }
}
