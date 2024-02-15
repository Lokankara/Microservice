package com.stack.model.gym;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

import static com.stack.model.gym.Role.ANDROID;
import static com.stack.model.gym.Role.BEEFCAKE;
import static com.stack.model.gym.Role.TERMINATOR;

@Getter
@Setter
@ToString
public class Jock {
    private Role role;
    private Sled[] sleds;
    private final String name;

    public Jock(
            String name,
            Sled[] sleds) {
        this.sleds = sleds;
        this.name = name;
        this.role = calculateRole(this.sleds);
    }

    private Role calculateRole(Sled[] sleds) {
        int amount = 0;
        for (Sled sled : sleds) {
            amount += sled.getWeight();
        }
        if (amount <= Role.AMOEBA.getCapacity()) {
            return Role.AMOEBA;
        } else if (amount >= BEEFCAKE.getCapacity() && amount < ANDROID.getCapacity()) {
            return BEEFCAKE;
        } else if (amount >= ANDROID.getCapacity() && amount < TERMINATOR.getCapacity()) {
            return ANDROID;
        } else {
            return TERMINATOR;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jock jock = (Jock) o;
        return role == jock.role
                && Arrays.equals(sleds, jock.sleds)
                && Objects.equals(name, jock.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(role, name);
        result = 31 * result + Arrays.hashCode(sleds);
        return result;
    }
}
