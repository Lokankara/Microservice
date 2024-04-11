package com.stack.automation.company.service;

import com.stack.automation.company.dao.EmployeeRepository;
import com.stack.automation.company.dao.memory.InMemoryBankRepository;
import com.stack.automation.company.dao.memory.InMemoryEmployeeRepository;
import com.stack.automation.company.model.Employee;
import com.stack.automation.company.dao.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class BankAccountService implements BankService{

    List<Employee> employees = new ArrayList<>();

    private final EmployeeRepository repository;
    private final BankRepository bankRepository;

    public BankAccountService(List<Employee> employees) {
        this.employees = employees;
        this.repository = new InMemoryEmployeeRepository(employees);
        this.bankRepository = new InMemoryBankRepository(getAccountBalances(employees));
    }

    private Map<String, Double> getAccountBalances(
            List<Employee> employees) {

        return employees.stream().collect(Collectors.toMap(
                Employee::getId,
                Employee::getSalary,
                (a, b) -> b));
    }

    @Override
    public void pay(String id, double salary) {
        if (repository.findById(id).isPresent()) {
            bankRepository.addAccount(id, salary);
            log.info("Payment processed for ID: %s, Amount: $%s".formatted(id, salary));
        } else {
            log.info("Employee with ID %s does not exist.".formatted(id));
        }
    }
}
