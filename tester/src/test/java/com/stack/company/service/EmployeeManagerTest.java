package com.stack.company.service;

import com.stack.company.dao.EmployeeRepository;
import com.stack.company.dao.memory.InMemoryEmployeeRepository;
import com.stack.company.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.testng.AssertJUnit.assertFalse;

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
    void testPaymentEmployeesWhenSeveralArePresent(){
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("1", 1000)));
        when(employeeRepository.findAll()).thenReturn(List.of(new Employee("2", 1000)));
        assertThat(employeeManager.payEmployees()).isEqualTo(1);
        verify(bankService).pay("2", 1000);
    }

    @Test
    void throwExceptionWhenEmpty() {
        doThrow(new RuntimeException()).when(bankService).pay(anyString(), anyDouble());
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
