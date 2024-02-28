package com.stack.model.provider;

import com.stack.model.time.MonthUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.stack.model.time.MonthUtils.*;

public class QuarterArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new MonthUtils[]{JANUARY, FEBRUARY, MARCH}, 1),
                Arguments.of(new MonthUtils[]{APRIL, MAY, JUNE}, 2),
                Arguments.of(new MonthUtils[]{JULY, AUGUST, SEPTEMBER}, 3),
                Arguments.of(new MonthUtils[]{OCTOBER, NOVEMBER, DECEMBER}, 4)
        );
    }
}
