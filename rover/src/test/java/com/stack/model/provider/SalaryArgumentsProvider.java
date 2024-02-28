package com.stack.model.provider;

import com.stack.model.company.BaseEmployee;
import com.stack.model.company.Gender;
import com.stack.model.company.Worker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class SalaryArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        BaseEmployee[] developers = {
                new Worker(30, "John", Gender.MALE, 5000),
                new Worker( 25, "Alice", Gender.FEMALE, 6000),
                new Worker( 40, "Bob", Gender.MALE, 7000)
        };

        BaseEmployee[] testers = {
                new Worker( 35, "Emma", Gender.FEMALE, 5500),
                new Worker( 28, "Tom", Gender.MALE, 4500)
        };

        return Stream.of(
                Arguments.of(developers, 216000.0),
                Arguments.of(testers, 120000.0)
        );
    }
}
