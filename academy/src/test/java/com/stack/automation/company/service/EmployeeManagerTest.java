package com.stack.automation.company.service;

import com.stack.automation.company.dao.EmployeeRepository;
import com.stack.automation.company.dao.memory.InMemoryEmployeeRepository;
import com.stack.automation.company.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
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
    void testPayment(){
        Mockito.when(employeeRepository.findAll()).thenReturn(emptyList());
        assertThat(employeeManager.payEmployees()).isZero();
    }

    @Test
    void testPaymentArePresent(){
        Mockito.when(employeeRepository.findAll()).thenReturn(asList(new Employee("1", 1000)));
        assertThat(employeeManager.payEmployees()).isEqualTo(1);
        Mockito.verify(bankService).pay("1", 1000);
    }

    @Test
    void testPaymentEmployeesWhenSeveralArePresent(){
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1", 1000)));
        Mockito.when(employeeRepository.findAll()).thenReturn(List.of(new Employee("2", 1000)));
        assertThat(employeeManager.payEmployees()).isEqualTo(1);
        Mockito.verify(bankService).pay("2", 1000);
    }

    @Test
    void throwExceptionWhenEmpty() {
        Mockito.doThrow(new RuntimeException()).when(bankService).pay(
                ArgumentMatchers.anyString(), ArgumentMatchers.anyDouble());
        employeeManager.payEmployees();

        assertThat(repository.findAll().get(0).isPaid()).isFalse();
    }

    @Test
    void employeeIsPaid() {
        manager.payEmployees();

        assertThat(new Employee("1", 50000).isPaid());
        assertThat(new Employee("2", 30000).isPaid());
    }

    @Test
    void shouldReturnEmptyList() {

        assertThat(repository.findAll().size()).isEqualTo(2);
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldNotChangeSize() {
        repository.save(new Employee("MA", 40000.0));
        int amount = repository.findAll().size();
        repository.save(new Employee("MA", 45000.0));

        assertThat(repository.findAll().size()).isEqualTo(3);
        assertEquals(amount, repository.findAll().size());
    }

    @Test
    void whenSavingEmployeeWithExistingIdShouldReplaceOldEmployee() {
        repository.save(new Employee("MA", 40000.0));
        repository.save(new Employee("MA", 45000.0));

        assertEquals(50000, repository.findAll().get(0).getSalary());

    }

    @Test
    void whenSavingEmployeeWithUniqueIdShouldChangeSize() {
        repository.save(new Employee("MA", 40000.0));
        int amount = repository.findAll().size();
        repository.save(new Employee("AM", 45000.0));

        assertNotEquals(amount, repository.findAll().size());
        assertThat(repository.findAll().size()).isEqualTo(4);
    }

    @Test
    void whenInitializingWithListShouldHaveSizeGreaterThanZero() {

        assertFalse(repository.findAll().isEmpty());
    }
}
