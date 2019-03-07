package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import static com.wiley.javainterviewsexposed.chapter07.Factorial.factorial;
import static junit.framework.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void runFactorial() {
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
        assertEquals(720, factorial(6));
        assertEquals(5040, factorial(7));
    }
}
