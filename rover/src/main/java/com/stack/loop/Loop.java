package com.stack.loop;

public class Loop {

    private static final int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task61();
        task62();
    }

    static void task1() {
        for (int number : array) {
            if (number % 2 != 0) {
                System.out.printf("%s ", number);
            }
        }
        System.out.printf("\t\t\t\t\t\t\t\t\t Task#1: Odd Numbers%n");
    }

    static void task2() {
        for (int number : array) {
            if (number > 5) {
                System.out.printf("%s ", number);
            }
        }
        System.out.printf("\t\t\t\t\t\t\t Task#2: Numbers Greater than 5%n");
    }

    private static void task3() {
        int i = 0;
        while (i < array.length) {
            array[i] += 15;
            System.out.printf("%s ", array[i]);
            i++;
        }
        System.out.printf("\t\t\t\t Task#3: Increase by 15%n");
    }

    private static void task4() {
        for (int i = 0; i < 16; i++) {
            System.out.printf("%s ", i);
        }
        System.out.printf("\t Task #4: Numbers from 0 to 15%n");
    }

    private static void task5() {
        int base = 5;
        int exponent = 0;
        double result = Math.pow(base, exponent);

        while (result < 10000) {
            System.out.printf("%d ", (int) result);
            exponent++;
            result = Math.pow(base, exponent);
        }
        System.out.println("\t\t\t\t\t Task#5: Powers of 5 less than 10000");
    }

    private static void task61() {
        for (int i = 40; i <= 60; i++) {
            if (i % 4 == 0) {
                System.out.printf("%d ", i);
            }
        }
        System.out.printf(
                "\t\t\t\t\t\t Task#6 Variant 1: Multiples of 4: 40 and 60%n");
    }

    private static void task62() {
        for (int i = 40; i <= 60; i += 4) {
            System.out.printf("%s ", i);
        }
        System.out.printf(
                "\t\t\t\t\t\t Task#6 Variant 2: Multiples of 4: 40 and 60%n");
    }
}
