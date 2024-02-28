package com.stack.model.provider;

import com.stack.model.company.BaseEmployee;
import com.stack.model.company.Director;
import com.stack.model.company.Employee;
import com.stack.model.company.Gender;
import com.stack.model.company.Manager;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class EmployeeUtilsArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        BaseEmployee[] managers = {
                new Manager(35, "Jack", Gender.MALE, 10000, 20, 10),
                new Manager(40, "Jill", Gender.FEMALE, 10000, 20,  0),
                new Manager(40, "Joan", Gender.FEMALE, 10000, 20,  1),
                new Manager(31, "John", Gender.MALE, 10000, 20, -1)
        };
        BaseEmployee[] directors = {
                new Director(45, "Bob", Gender.MALE, 10000,  100, 10),
                new Director(42, "Jack", Gender.MALE, 10000,  50, 1),
                new Director(50, "Emily", Gender.FEMALE, 10000,  100, 0),
                new Director(50, "Kate", Gender.FEMALE,10000,  100, 1)
        };
        return Stream.of(
                Arguments.of(managers, 0, 123000, 3000),
                Arguments.of(directors, 1, 123000, 9000)
        );
    }
}
