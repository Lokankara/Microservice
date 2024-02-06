package com.stack.loop;

public class Fibonacci {

    public String fibonacci(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(binetFibonacci(i)).append(" ");
        }
        return builder.toString();
    }

    int binetFibonacci(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) ((Math.pow(goldenRatio, n)
                - Math.pow(-goldenRatio, -n))
                / Math.sqrt(5));
    }
}
