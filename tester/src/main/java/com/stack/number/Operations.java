package com.stack.number;

public class Operations {
    private Operations() {
    }

    public static double sumAndMultiplyByPi(Integer[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum * Math.PI;
    }

    public static double multiplyAllAndMultiplyByE(Short[] numbers) {
        int product = 1;
        for (short number : numbers) {
            product *= number;
        }
        return product * Math.E;
    }
}
