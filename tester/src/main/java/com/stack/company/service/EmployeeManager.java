package com.stack.company.service;

import com.stack.company.dao.EmployeeRepository;
import com.stack.company.model.Employee;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmployeeManager implements EmployeeService {
    private final BankService bankService;
    private final EmployeeRepository employeeRepository;

    public EmployeeManager(
            EmployeeRepository employeeRepository,
            BankService bankService) {
        this.employeeRepository = employeeRepository;
        this.bankService = bankService;
    }

    public int payEmployees(){
        int payments = 0;
        for (Employee employee : employeeRepository.findAll()) {
            try {
                bankService.pay(employee.getId(), employee.getSalary());
                employee.setPaid(true);
                payments++;
            } catch (RuntimeException e){
                log.error(" " + employee, e);
                employee.setPaid(false);
            }
        }
        return payments;
    }
}
