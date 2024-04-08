package com.stack.model;

import java.time.LocalDate;
import java.util.Objects;

public final class User
        implements Comparable<User> {
    private final String name;
    private final LocalDate birthDate;

    public User(
            String name,
            LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

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

    public String name() {
        return name;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.name, that.name) && Objects.equals(this.birthDate,
                                                                      that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

}
