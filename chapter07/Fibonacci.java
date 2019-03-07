package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class Fibonacci {

    @Test
    public void fibonacciList() {
        assertEquals(0, fibonacci(0).size());
        assertEquals(Arrays.asList(0), fibonacci(1));
        assertEquals(Arrays.asList(0, 1), fibonacci(2));
        assertEquals(Arrays.asList(0, 1, 1), fibonacci(3));
        assertEquals(Arrays.asList(0, 1, 1, 2), fibonacci(4));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3), fibonacci(5));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), fibonacci(6));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), fibonacci(7));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13), fibonacci(8));
    }

    public static List<Integer> fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "n must not be less than zero");
        }

        if (n == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            return Arrays.asList(0);
        }

        if (n == 2) {
            return Arrays.asList(0, 1);

        }
        final List<Integer> seq = new ArrayList<>(n);
        seq.add(0);
        n = n - 1;
        seq.add(1);
        n = n - 1;

        while (n > 0) {
            int a = seq.get(seq.size() - 1);
            int b = seq.get(seq.size() - 2);
            seq.add(a + b);
            n = n - 1;
        }

        return seq;
    }

    @Test
    public void verifyFibN() {
        assertEquals(0, fibN(0));
        assertEquals(1, fibN(1));
        assertEquals(1, fibN(2));
        assertEquals(2, fibN(3));
        assertEquals(21, fibN(8));
    }

     public static int fibN(int n) {
         if (n < 0) {
             throw new IllegalArgumentException(
                     "n must not be less than zero");
         }
         if (n == 1) return 1;
         if (n == 0) return 0;
         return (fibN(n - 1) + fibN(n - 2));
     }


    @Test
    public void largeFib() {
        final long nonCachedStart = System.nanoTime();
        assertEquals(1134903170, fibN(45));
        final long nonCachedFinish = System.nanoTime();
        assertEquals(1134903170, cachedFibN(45));
        final long cachedFinish = System.nanoTime();

        System.out.printf(
                "Non cached time: %d nanoseconds%n",
                nonCachedFinish - nonCachedStart);
        System.out.printf(
                "Cached time: %d nanoseconds%n",
                cachedFinish - nonCachedFinish);
    }

    private Map<Integer, Integer> fibCache = new HashMap<>();

    public int cachedFibN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "n must not be less than zero");
        }
        fibCache.put(0, 0);
        fibCache.put(1, 1);
        return recursiveCachedFibN(n);
    }

    private int recursiveCachedFibN(int n) {
        if (fibCache.containsKey(n)) {
            return fibCache.get(n);
        }

        int value = recursiveCachedFibN(n - 1) + recursiveCachedFibN(n - 2);
        fibCache.put(n, value);
        return value;
    }
}
