package com.stack.model.gym;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    @ParameterizedTest
    @ArgumentsSource(GymArgumentsProvider.class)
    void testCalculateWeight(Jock jock, Role expectedRole) {
        assertEquals(expectedRole, jock.getRole());
    }

    @Test
    void testJock(){
        Sled ten = new Sled(10);
        Sled[] amoeba = {ten};
        Sled[] beefcake = {ten, ten, ten};
        Jock alice = new Jock("Alice", amoeba);
        Jock alice1 = new Jock("Alice", beefcake);
        System.out.println(alice1.hashCode());
        System.out.println(alice.hashCode());
    }
}
