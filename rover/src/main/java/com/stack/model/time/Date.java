package com.stack.model.time;

public record Date(int day, MonthUtils month, int year) {

    public Date plusDays(int day) {
        return new Date(this.day + day, MonthUtils.FEBRUARY, year);
    }
}
