package com.stack.model.company;

import java.util.Objects;

public abstract class Entity {
    protected String name;
    protected int age;
    protected Gender gender;

    protected Entity(
            String name,
            int age,
            Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return age == entity.age
                && Objects.equals(name, entity.name)
                && gender == entity.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
