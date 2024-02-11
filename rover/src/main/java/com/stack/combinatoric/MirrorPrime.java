package com.stack.combinatoric;

public class MirrorPrime {

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int reverse(int n) {
        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    public int countMirrorPrimes(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i) && isPrime(reverse(i))) {
                count++;
            }
        }
        return count;
    }
}
