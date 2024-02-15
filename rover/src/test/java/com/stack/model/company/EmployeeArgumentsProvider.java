package com.stack.model.company;

import com.stack.model.company.Employee;
import com.stack.model.company.Gender;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class EmployeeArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        Employee jack = new Employee("Jack", 30, Gender.MAN, 5000);
        Employee bob = new Employee("Bob", 35, Gender.MAN, 6000);
        Employee alice = new Employee("Alice", 25, Gender.WOMAN, 4500);

        return Stream.of(
                Arguments.of(jack, jack, true),
                Arguments.of(alice, jack, false),
                Arguments.of(bob, jack, false),
                Arguments.of(bob, alice, false),
                Arguments.of(alice, alice, true)
        );
    }
}
