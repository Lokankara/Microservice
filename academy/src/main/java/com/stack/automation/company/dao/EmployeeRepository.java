package com.stack.automation.company.dao;

import com.stack.automation.company.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(String id);
}
