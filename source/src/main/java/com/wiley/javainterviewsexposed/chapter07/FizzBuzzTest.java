package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.wiley.javainterviewsexposed.chapter07.FizzBuzz.fizzBuzz;
import static com.wiley.javainterviewsexposed.chapter07.FizzBuzz.alternativeFizzBuzz;
import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    private final List<String> expected = Arrays.asList(
            "1", "2", "Fizz",
            "4", "Buzz", "Fizz",
            "7", "8", "Fizz",
            "Buzz", "11", "Fizz",
            "13", "14", "FizzBuzz",
            "16", "17", "Fizz",
            "19", "Buzz");

    @Test
    public void vanillaFizzBuzz() {
        assertEquals(expected, fizzBuzz(20));
    }

    @Test
    public void reuseFizzBuzz() {
        assertEquals(expected, alternativeFizzBuzz(20));
    }
}
