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
                Arguments.of("Jack", 35, Gender.MAN, 200, 5, 2001, 54810.0),
                Arguments.of("Alice", 40, Gender.WOMAN, 250, 3, 2023, 66950.0),
                Arguments.of("Bob", 30, Gender.MAN, 150, 0, 2022, 39000.0),
                Arguments.of("Charlie", 45, Gender.MAN, 300, 10, 2024, 86460.0),
                Arguments.of("Emma", 38, Gender.WOMAN, 220, 7, 2023, 61204.0),
                Arguments.of("David", 50, Gender.MAN, 180, 4, 2021, 48859.2),
                Arguments.of("Sophia", 42, Gender.WOMAN, 270, 2, 2020, 72154.8),
                Arguments.of("Ethan", 33, Gender.MAN, 190, 6, 2025, 52565.4),
                Arguments.of("Olivia", 39, Gender.WOMAN, 280, 8, 2024, 79228.8),
                Arguments.of("Liam", 36, Gender.MAN, 210, 1, 2023, 55146.0),
                Arguments.of("Ava", 43, Gender.WOMAN, 260, 9, 2022, 73684.0),
                Arguments.of("Noah", 31, Gender.MAN, 170, 5, 2021, 46588.5),
                Arguments.of("Isabella", 37, Gender.WOMAN, 240, 4, 2020, 65395.2),
                Arguments.of("James", 45, Gender.MAN, 300, 7, 2025, 83781.0),
                Arguments.of("Mia", 32, Gender.WOMAN, 210, 3, 2024, 56670.6)
        );
    }
}
