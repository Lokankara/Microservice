package com.stack.model.provider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static com.stack.model.time.MonthUtils.APRIL;
import static com.stack.model.time.MonthUtils.AUGUST;
import static com.stack.model.time.MonthUtils.DECEMBER;
import static com.stack.model.time.MonthUtils.FEBRUARY;
import static com.stack.model.time.MonthUtils.JANUARY;
import static com.stack.model.time.MonthUtils.JULY;
import static com.stack.model.time.MonthUtils.JUNE;
import static com.stack.model.time.MonthUtils.MARCH;
import static com.stack.model.time.MonthUtils.MAY;
import static com.stack.model.time.MonthUtils.NOVEMBER;
import static com.stack.model.time.MonthUtils.OCTOBER;
import static com.stack.model.time.MonthUtils.SEPTEMBER;
import static com.stack.model.time.Week.FRIDAY;
import static com.stack.model.time.Week.MONDAY;
import static com.stack.model.time.Week.SATURDAY;
import static com.stack.model.time.Week.SUNDAY;
import static com.stack.model.time.Week.THURSDAY;
import static com.stack.model.time.Week.TUESDAY;
import static com.stack.model.time.Week.WEDNESDAY;

public class DayArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(1, JANUARY, 2000, SATURDAY, false),
                Arguments.of(2, JANUARY, 2000, SUNDAY, false),
                Arguments.of(1, FEBRUARY, 2000, TUESDAY, true),
                Arguments.of(29, FEBRUARY, 2000, TUESDAY, true),
                Arguments.of(1, MARCH, 2000, WEDNESDAY, true),
                Arguments.of(1, APRIL, 2000, SATURDAY, false),
                Arguments.of(1, MAY, 2000, MONDAY, true),
                Arguments.of(1, JUNE, 2000, THURSDAY, true),
                Arguments.of(1, JULY, 2000, SATURDAY, false),
                Arguments.of(1, AUGUST, 2000, TUESDAY, true),
                Arguments.of(1, SEPTEMBER, 2000, FRIDAY, true),
                Arguments.of(1, OCTOBER, 2000, SUNDAY, false),
                Arguments.of(1, NOVEMBER, 2000, WEDNESDAY, true),
                Arguments.of(1, DECEMBER, 2000, FRIDAY, true),
                Arguments.of(31, DECEMBER, 2000, SUNDAY, false),
                Arguments.of(3, JANUARY, 2000, MONDAY, true),
                Arguments.of(4, JANUARY, 2000, TUESDAY, true),
                Arguments.of(5, JANUARY, 2000, WEDNESDAY, true),
                Arguments.of(6, JANUARY, 2000, THURSDAY, true),
                Arguments.of(7, JANUARY, 2000, FRIDAY, true),
                Arguments.of(8, JANUARY, 2000, SATURDAY, false),
                Arguments.of(9, JANUARY, 2000, SUNDAY, false),
                Arguments.of(10, JANUARY, 2000, MONDAY, true),
                Arguments.of(1, JANUARY, 2024, MONDAY, true),
                Arguments.of(1, FEBRUARY, 2024, THURSDAY, true),
                Arguments.of(1, MARCH, 2024, FRIDAY, true),
                Arguments.of(1, APRIL, 2024, MONDAY, true),
                Arguments.of(1, MAY, 2024, WEDNESDAY, true),
                Arguments.of(1, JANUARY, 2001, MONDAY, true),
                Arguments.of(2, JANUARY, 2001, TUESDAY, true),
                Arguments.of(3, JANUARY, 2001, WEDNESDAY, true),
                Arguments.of(4, JANUARY, 2001, THURSDAY, true),
                Arguments.of(5, JANUARY, 2001, FRIDAY, true),
                Arguments.of(6, JANUARY, 2001, SATURDAY, false),
                Arguments.of(7, JANUARY, 2001, SUNDAY, false),
                Arguments.of(8, JANUARY, 2001, MONDAY, true),
                Arguments.of(9, JANUARY, 2001, TUESDAY, true),
                Arguments.of(10, JANUARY, 2001, WEDNESDAY, true),
                Arguments.of(1, JANUARY, 2025, WEDNESDAY, true),
                Arguments.of(1, FEBRUARY, 2025, SATURDAY, false),
                Arguments.of(1, MARCH, 2025, SATURDAY, false),
                Arguments.of(1, APRIL, 2025, TUESDAY, true),
                Arguments.of(1, MAY, 2025, THURSDAY, true)
        );
    }
}
