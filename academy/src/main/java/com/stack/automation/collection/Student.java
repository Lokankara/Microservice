package com.stack.automation.collection;

import java.util.Objects;

public class Student {
    private final int id;
    private final String name;

    public Student(
            int id,
            String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return 31 * id + (name != null ? name.hashCode() : 0);
    }
}
