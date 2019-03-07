package com.wiley.javainterviewsexposed.chapter07;

public class Factorial {

    public static long factorial(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(
                    "n must be greater than zero");
        }

        long toReturn = 1;
        for (int i = 1; i <= n; i++) {
            toReturn *= i;
        }

        return toReturn;
    }
}
