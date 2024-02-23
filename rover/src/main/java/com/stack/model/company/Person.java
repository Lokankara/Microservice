package com.stack.model.company;

public class Person extends Human {

    public Person(
            String name,
            int age,
            Gender gender) {
        super(name, age, gender);
    }

    @Override
    public String getName() {
        return getGender() == Gender.MALE
               ? "Mr. %s".formatted(super.getName())
               : "Mrs. %s".formatted(super.getName());
    }

    @Override
    public String toString() {
        return "Person{name='%s', age=%d, gender=%s}"
                .formatted(getName(), getAge(), getGender());
    }
}
