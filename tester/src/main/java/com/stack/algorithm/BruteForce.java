package com.stack.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BruteForce {

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
        return result.mod(pBigInteger)
                     .equals(BigInteger.ZERO);
    }

    public boolean isPrimeClassic(int x) {
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

    public List<Integer> primeFactors(int n) {
        List<Integer> factors = new LinkedList<>();
        if (n < 2) {
            return factors;
        }
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    factors.add(i);
                    n /= i;
                }
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public BigInteger[] fermatFactor(BigInteger n) {
        BigInteger a = sqrt(n);
        BigInteger b2 = a.multiply(a).subtract(n);
        BigInteger b = sqrt(b2);
        while (!b.multiply(b).equals(b2)) {
            a = a.add(BigInteger.ONE);
            b2 = a.multiply(a).subtract(n);
            b = sqrt(b2);
        }
        return new BigInteger[]{a.subtract(b), a.add(b)};
    }

    private BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
        BigInteger div2 = div;
        for (; ; ) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }

    public List<Integer> fermatFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n % 2 == 0) {
            factors.add(2);
            while (n % 2 == 0){
                n /= 2;
            }
        }
        int a = (int) Math.ceil(Math.sqrt(n));
        int square = a * a - n;
        while (isSquare(square)){
            a++;
            square = a * a - n;
        }
        int b = (int) Math.sqrt(square);
        factors.add(a - b);
        factors.add(a + b);
        return factors;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int countDivisors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }
}
