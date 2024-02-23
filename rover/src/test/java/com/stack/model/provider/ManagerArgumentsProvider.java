package com.stack.model.provider;

import com.stack.model.company.Gender;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ManagerArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        return Stream.of(
                Arguments.of("Jack", 35, Gender.MALE, 200, 5, 2001, 337710.0),
                Arguments.of("Alice", 40, Gender.FEMALE, 250, 3, 2023, 332474),
                Arguments.of("Bob", 30, Gender.MALE, 150, 0, 2022, 279000.0),
                Arguments.of("Charlie", 45, Gender.MALE, 300, 10, 2024, 414060.0),
                Arguments.of("Emma", 38, Gender.FEMALE, 220, 7, 2023, 361768.0),
                Arguments.of("David", 50, Gender.MALE, 180, 4, 2021, 323035.2),
                Arguments.of("Sophia", 42, Gender.FEMALE, 270, 2, 2020, 329098.8),
                Arguments.of("Ethan", 33, Gender.MALE, 190, 6, 2025, 344261.4),
                Arguments.of("Olivia", 39, Gender.FEMALE, 280, 8, 2024, 388732.8),
                Arguments.of("Liam", 36, Gender.MALE, 210, 1, 2023, 303582.0),
                Arguments.of("Ava", 43, Gender.FEMALE, 260, 9, 2022, 392200.0),
                Arguments.of("Noah", 31, Gender.MALE, 170, 5, 2021, 329488.5),
                Arguments.of("Isabella", 37, Gender.FEMALE, 240, 4, 2020, 339571.2),
                Arguments.of("James", 45, Gender.MALE, 300, 7, 2025, 384345.0),
                Arguments.of("Mia", 32, Gender.FEMALE, 210, 3, 2024, 322194.6)
        );
    }
}
