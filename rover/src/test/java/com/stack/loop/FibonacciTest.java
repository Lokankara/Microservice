package com.stack.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacci() {
        String fibonacci = new Fibonacci().fibonacci(25);
        assertNotNull(fibonacci);
        System.out.println(fibonacci);
    }
}
