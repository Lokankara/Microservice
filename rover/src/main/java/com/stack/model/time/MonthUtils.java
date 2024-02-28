package com.stack.model.time;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public enum MonthType {
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    public static final MonthType[] MONTHS = MonthType.values();
    private final String name;

    private boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getDays(int year) {
        return switch (this) {
            case FEBRUARY -> (leapYear(year) ? 29 : 28);
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> 31;
        };
    }

    public Day[] getDaysOfMonth(int year) {
        int days = getDays(year);
        Day[] daysArray = new Day[days];
        for (int i = 0; i < days; i++) {
            daysArray[i] =  new Day(i + 1, this.ordinal() + 1, year);
        }
        return daysArray;
    }

    public int getWorkingDays(int year) {
        int workingDays = 0;
        for (int i = 0; i < getDays(year); i++) {
            LocalDate currentDate = LocalDate.of(year, this.ordinal() + 1, 1).plusDays(i);
            if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY
                    && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays++;
            }
        }
        return workingDays;
    }
}
