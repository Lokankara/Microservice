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
                Arguments.of(30, Gender.MAN, "John", "Mr. John", "Person{name='John', age=30, gender=MAN}"),
                Arguments.of(25, Gender.WOMAN, "Alice", "Mrs. Alice", "Person{name='Alice', age=25, gender=WOMAN}")
        );
    }
}
