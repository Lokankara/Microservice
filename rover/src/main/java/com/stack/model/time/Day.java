package com.stack.model.time;

import lombok.Getter;

public class Day {
    private final int number;
    @Getter
    private final Week dayOfWeek;
    private final boolean isWorkingDay;
    
    public Day(
            int day,
            int month,
            int year) {
        this.number = day;
        this.dayOfWeek = getDayOfWeek(month, year);
        this.isWorkingDay = isDayWorking();
    }

    public Week getDayOfWeek(int month, int year) {
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        year -= (month < 3) ? 1 : 0;
        int h = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + number) % 7;
        return Week.values()[(h + 6) % 7];
    }

    private boolean isDayWorking() {
        return dayOfWeek != Week.SATURDAY && dayOfWeek != Week.SUNDAY;
    }

    public boolean isWorkingDay() {
        return isWorkingDay;
    }
}
