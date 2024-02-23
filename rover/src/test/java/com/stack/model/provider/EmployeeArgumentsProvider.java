package com.stack.model.provider;

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
        Employee jack = new Employee(30, "Jack", Gender.MALE, 5000);
        Employee bob = new Employee(35, "Bob", Gender.MALE, 6000);
        Employee alice = new Employee(25, "Alice", Gender.FEMALE, 4500);

        return Stream.of(
                Arguments.of(jack, jack, true),
                Arguments.of(alice, jack, false),
                Arguments.of(bob, jack, false),
                Arguments.of(bob, alice, false),
                Arguments.of(alice, alice, true)
        );
    }
}
