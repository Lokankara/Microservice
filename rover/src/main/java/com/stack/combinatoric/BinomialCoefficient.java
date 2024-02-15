package com.stack.combinatoric;

public class BinomialCoefficient {
    public static void printPascalPyramid(int rows) {
        int maxDigits = digitsInNumber(binomialCoefficient(rows - 1, rows / 2));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                int coefficient = binomialCoefficient(i, j);
                printSpaces(maxDigits - digitsInNumber(coefficient));
                System.out.print(coefficient + " ");
            }
            System.out.println();
        }
    }

    public static int binomialCoefficient(int n, int k) {
        return k == 0 || k == n
               ? 1 : binomialCoefficient(n - 1, k - 1)
                       + binomialCoefficient(n - 1, k);
    }

    public static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static int digitsInNumber(int number) {
        if (number < 10) {
            return 1;
        } else if (number < 100) {
            return 2;
        } else {
            return 3;
        }
    }
}
