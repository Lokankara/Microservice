package com.stack.algorithm;

import java.math.BigInteger;

public class Algorithm {
    public int gcd(
            int a,
            int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public BigInteger factorial(int x) {
        if (x == 0 || x == 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public boolean isPrimeWilson(int p) {
        BigInteger factorialPMinusOne = factorial(p - 1);
        BigInteger pBigInteger = BigInteger.valueOf(p);
        BigInteger result = factorialPMinusOne.add(BigInteger.ONE);
        return result.mod(pBigInteger).equals(BigInteger.ZERO);
    }


    public boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
