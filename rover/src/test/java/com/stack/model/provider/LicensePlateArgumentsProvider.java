package com.stack.model.provider;

import com.stack.model.license.State;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class LicensePlateArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(State.CALIFORNIA, 1, "CA-1"),
                Arguments.of(State.CALIFORNIA, 2, "CA-2"),
                Arguments.of(State.NEW_YORK, 300, "NY-300"),
                Arguments.of(State.NEW_YORK, 301, "NY-301")
        );
    }
}
