package com.stack.model.provider;

import com.stack.model.company.Gender;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class PersonArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(30, Gender.MALE, "John", "Mr. John", "Person{name='Mr. John', age=30, gender=MALE}"),
                Arguments.of(25, Gender.FEMALE, "Alice", "Mrs. Alice", "Person{name='Mrs. Alice', age=25, gender=FEMALE}")
        );
    }
}
