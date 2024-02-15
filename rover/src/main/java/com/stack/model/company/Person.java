package com.stack.model.company;

public class Person extends Entity {

    public Person(
            String name,
            int age,
            Gender gender) {
        super(name, age, gender);
    }

    public String getName() {
        return gender == Gender.MAN
               ? "Mr. %s".formatted(name)
               : "Mrs. %s".formatted(name);
    }

    @Override
    public String toString() {
        return "Person{name='%s', age=%d, gender=%s}"
                .formatted(name, age, gender);
    }
}
