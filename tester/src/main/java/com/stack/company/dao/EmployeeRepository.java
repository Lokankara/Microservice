package com.stack.company.dao;

import com.stack.company.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(String id);
}
