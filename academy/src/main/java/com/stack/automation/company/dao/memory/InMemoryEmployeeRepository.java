package com.stack.automation.company.dao.memory;

import com.stack.automation.company.dao.EmployeeRepository;
import com.stack.automation.company.model.Employee;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class InMemoryEmployeeRepository
        implements EmployeeRepository {

    private final List<Employee> employees;

    public InMemoryEmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee save(Employee employee) {
        ListIterator<Employee> iterator = employees.listIterator();
        while (iterator.hasNext()){
            if(iterator.next().getId().equals(employee.getId())){
                iterator.set(employee);
                return employee;
            }
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Optional<Employee> findById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }
}
