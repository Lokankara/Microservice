package com.stack.automation.company.dao;

import com.stack.automation.company.dao.memory.InMemoryEmployeeRepository;
import com.stack.automation.company.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryEmployeeRepositoryTest {

    private static InMemoryEmployeeRepository repository;
    private static List<Employee> employees;
    private static Employee e1;
    private static Employee e2;

    @BeforeAll
    static void beforeAll() {
        e1 = new Employee("1", 1000);
        e2 = new Employee("2", 1000);
        employees = new ArrayList<>();
        employees.addAll(Arrays.asList(e1, e2));
        repository = new InMemoryEmployeeRepository(employees);
    }

    @Test
    void testFindAll(){
        List<Employee> all = repository.findAll();
        Assertions.assertThat(all).containsExactly(e1, e2);
    }

    @Test
    void testSaveNewEmployee(){
        Employee employee = new Employee("3", 1000);
        Employee saved = repository.save(employee);
        assertThat(saved).isNotNull();
        Assertions.assertThat(employees).contains(saved);
    }

    @Test
    void testSaveNewEmployeeExisting(){
        Employee employee = new Employee("2", 1000);
        Employee saved = repository.save(employee);

        assertThat(saved).isNotNull();
//        assertThat(employees).doesNotContain(saved);
        assertThat(saved.getFirstname()).isEqualTo(employee.getFirstname());
        assertThat(saved).isNotNull();
    }
}
