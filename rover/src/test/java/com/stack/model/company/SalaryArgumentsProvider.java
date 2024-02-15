package com.stack.model.company;

import com.stack.model.company.Employee;
import com.stack.model.company.Gender;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SalaryArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Employee[] developers = {
                new Employee("John", 30, Gender.MAN, 5000),
                new Employee("Alice", 25, Gender.WOMAN, 6000),
                new Employee("Bob", 40, Gender.MAN, 7000)
        };

        Employee[] testers = {
                new Employee("Emma", 35, Gender.WOMAN, 5500),
                new Employee("Tom", 28, Gender.MAN, 4500)
        };

        return Stream.of(
                Arguments.of(developers, 18000.0),
                Arguments.of(testers, 10000.0)
        );
    }
}
