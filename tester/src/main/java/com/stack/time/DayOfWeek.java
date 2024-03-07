package com.stack.time;

import lombok.Getter;

@Getter
public enum DayOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String day;

    DayOfWeek(String day) {
        this.day = day;
    }

    public static String getDayOfWeek(Integer dayNumber) {
        return dayNumber == null || dayNumber < 1 || dayNumber > 7
               ? "Incorrect number of week"
               : DayOfWeek.values()[dayNumber - 1].getDay();
    }
}
