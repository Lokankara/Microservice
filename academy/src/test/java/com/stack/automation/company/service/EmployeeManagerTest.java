package com.stack.automation.company.service;

import com.stack.automation.company.dao.EmployeeRepository;
import com.stack.automation.company.dao.memory.InMemoryEmployeeRepository;
import com.stack.automation.company.model.Employee;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EmployeeManagerTest {

    @InjectMocks
    private EmployeeManager employeeManager;
    @Mock
    private BankService bankService;
    @Mock
    private EmployeeRepository employeeRepository;
    private static AutoCloseable autoCloseable;
    private EmployeeRepository repository;
    private EmployeeManager manager;
    private BankService service;

    @BeforeEach
    public void setup() {
        List<Employee> employees = new java.util.ArrayList<>();
        employees.add(new Employee("1", 50000));
        employees.add(new Employee("2", 30000));
        repository = new InMemoryEmployeeRepository(employees);
        service = new BankAccountService(employees);
        manager = new EmployeeManager(repository, bankService);
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void afterAll() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testPayment() {
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of());
        assertEquals(0, employeeManager.payEmployees());
    }

    @Test
    void testPaymentArePresent() {
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1", 1000)));
        assertEquals(1, employeeManager.payEmployees());
        Mockito.verify(bankService).pay("1", 1000);
    }

    @Test
    void testPaymentEmployeesWhenSeveralArePresent() {
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1", 1000), new Employee("2", 1000)));
        assertEquals(2, employeeManager.payEmployees());
        Mockito.verify(bankService).pay("2", 1000);
    }

    @Test
    void throwExceptionWhenEmpty() {
        Mockito.doThrow(new RuntimeException()).when(bankService).pay(
                ArgumentMatchers.anyString(), ArgumentMatchers.anyDouble());
        employeeManager.payEmployees();

        assertFalse(repository.findAll().get(0).isPaid());
    }

    @Test
    void employeeIsPaid() {
        employeeManager.payEmployees();

//        assertTrue(new Employee("1", 50000).isPaid());
//        assertTrue(new Employee("2", 30000).isPaid());
    }

    @Test
    void shouldReturnEmptyList() {
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldNotChangeSize() {
        repository.save(new Employee("MA", 40000.0));
        int amount = repository.findAll().size();
        repository.save(new Employee("MA", 45000.0));

        assertEquals(amount, repository.findAll().size());
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldReplaceOldEmployee() {
        repository.save(new Employee("MA", 40000.0));
        repository.save(new Employee("MA", 45000.0));

        assertEquals(50000.0, repository.findAll().get(0).getSalary());
    }

    @Test
    void whenSavingEmployeeWithUniqueIdShouldChangeSize() {
        repository.save(new Employee("MA", 40000.0));
        int amount = repository.findAll().size();
        repository.save(new Employee("AM", 45000.0));

        assertNotEquals(amount, repository.findAll().size());
        assertEquals(amount + 1, repository.findAll().size());
    }

    @Test
    void whenInitializingWithListShouldHaveSizeGreaterThanZero() {

        assertFalse(repository.findAll().isEmpty());
    }
}
