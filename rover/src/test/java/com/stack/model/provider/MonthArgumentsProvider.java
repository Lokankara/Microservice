package com.stack.model.provider;

import com.stack.model.time.MonthUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MonthArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context)
            throws Exception {
        return Stream.of(Arguments.of(MonthUtils.FEBRUARY, 2024, 21, 29),
                         Arguments.of(MonthUtils.FEBRUARY, 2020, 20, 29),
                         Arguments.of(MonthUtils.MARCH, 2024, 21, 31),
                         Arguments.of(MonthUtils.APRIL, 2024, 22, 30),
                         Arguments.of(MonthUtils.MAY, 2024, 23, 31),
                         Arguments.of(MonthUtils.JUNE, 2024, 20, 30),
                         Arguments.of(MonthUtils.JULY, 2024, 23, 31),
                         Arguments.of(MonthUtils.AUGUST, 2024, 22, 31),
                         Arguments.of(MonthUtils.SEPTEMBER, 2024, 21, 30),
                         Arguments.of(MonthUtils.OCTOBER, 2024, 23, 31),
                         Arguments.of(MonthUtils.NOVEMBER, 2024, 21, 30),
                         Arguments.of(MonthUtils.DECEMBER, 2024, 22, 31),
                         Arguments.of(MonthUtils.FEBRUARY, 2000, 21, 29),
                         Arguments.of(MonthUtils.FEBRUARY, 2100, 20, 28));
    }
}
