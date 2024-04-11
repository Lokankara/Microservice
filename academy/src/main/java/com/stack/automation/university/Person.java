package com.stack.automation.university;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Person {
    private String lastName;
    private String firstName;
    private int age;
}
