package com.stack.condition;

import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

@Slf4j
public class Conditions {

    private static final Random rnd = new Random();

    public static void main(String[] args) {
        input();
        task1();
        task2();
        task3();
        guess(5);
        game();
    }

    private static void input() {
        log.info("Enter '0' to quit.");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("0")) {
            input = scanner.nextLine();
            log.info("You entered: " + input);
        }
        scanner.close();
    }

    public static void task1() {

        int a = rnd.nextInt(50);
        int b = rnd.nextInt(50);

        display(a, b, "task 1");

        if (a == b) {
            log.info("a == b");
        } else if (a < b) {
            log.info("a < b");
        } else {
            log.info("a > b");
        }
    }

    public static void task2() {
        int a = rnd.nextInt(50);
        int b = rnd.nextInt(50);

        display(a, b, "task 2");

        log.info((a + b) % 2 == 0
                 ? "maybe a and b are even"
                 : "some variable is odd");
    }

    public static void task3() {
        log.info("--------------- task 3 ---------------");
        int a = rnd.nextInt(101);
        if (a > 10) {
            log.info("{} = > 10", a);
        }
        if (a < 100) {
            log.info("{} = < 100", a);
        }
        if (a * 1.0 / 2 > 20) {
            log.info("{} = a / 2 > 20", a);
        }
        if (a > 4 && a < 41) {
            log.info("{} = a > 4 && a < 41", a);
        } else {
            log.info("{} = a < 5 || a > 40", a);
        }
    }

    public static void display(
            int a,
            int b,
            String task) {
        log.info( "--------------- {} ---------------", task);
        log.info("a = {}", a);
        log.info("b = {}", b);
    }

    public static void game() {

        int targetNumber = rnd.nextInt(100) + 1;

        int maxAttempts = 5;
        int attempts = 0;
        boolean isGuessed = false;

        Scanner scanner = new Scanner(System.in);

        log.info("--------------- guess --------------");
        log.info("Try to guess the number between 1 and 100.");

        while (attempts < maxAttempts && !isGuessed) {
            log.info("Enter your guess: ");
            int userGuess = scanner.nextInt();
            if (userGuess == targetNumber) {
                log.info("Congratulations! You guessed the correct number.");
                isGuessed = true;
            } else {
                log.info("Incorrect. The correct number is {} than your guess",
                         (userGuess < targetNumber ? "greater" : "less"));
            }

            attempts++;
            int remainingAttempts = maxAttempts - attempts;
            log.info("Attempts remaining: " + remainingAttempts);
        }

        if (!isGuessed) {
            log.info("You've run out of attempts. The correct number was: {}",
                     targetNumber);
        }
        scanner.close();
    }

    public static void guess(int max) {
        Scanner scanner = new Scanner(System.in);
        log.info("--------------- guess v.2 --------------");
        log.info("Think of a number between 1 and 100, and I'll try to guess it.");
        int attempts = 0;
        int lowerBound = 1;
        int upperBound = 100;
        boolean isGuessed = false;


        while (!isGuessed && attempts < max) {
            int guess = (lowerBound + upperBound) / 2;
            log.info("Is your number {} ?", guess);
            log.info("Enter '+' if your number is higher, '-' if lower, or '0' if correct:");
            char userResponse;
            while (true) {
                try {
                    String input = scanner.next();
                    if (input.length() == 1) {
                        userResponse = input.charAt(0);
                        break;
                    } else {
                        throw new NoSuchElementException();
                    }
                } catch (NoSuchElementException e) {
                    log.info("Invalid input. Please enter '+', '-', or '0'.");
                    scanner.nextLine();
                }
            }

            switch (userResponse) {
                case '+' -> lowerBound = guess + 1;
                case '-' -> upperBound = guess - 1;
                case '0' -> {
                    log.info("Yay! I guessed your number.");
                    isGuessed = true;
                }
                default -> log.info("Invalid input. Please enter '+', '-', or '0'.");
            }

            attempts++;
        }

        if (!isGuessed) {
            log.info("Sorry, you've reached the maximum number of attempts");
            return;
        }

        scanner.close();
    }
}
