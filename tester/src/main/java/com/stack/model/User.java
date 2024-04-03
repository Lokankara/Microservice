package com.stack.model;

import java.time.LocalDate;

public record User(String name, LocalDate birthDate)
        implements Comparable<User> {

    @Override
    public String toString() {
        return String.format("User{name: %s, birthDate: %s}", name, birthDate);
    }

    @Override
    public int compareTo(User user) {
        int birthDay = this.birthDate.compareTo(user.birthDate);
        return birthDay != 0
               ? birthDay
               : this.name.compareTo(user.name);
    }
}
