package com.stack.automation.university;

import java.util.List;

public record Course(String name, String code, List<String> topics) {

    @Override
    public String toString() {
        return String.format(
                "Course{name='%s', code='%s', topics=%s}",
                name(), code(), topics());
    }
}
