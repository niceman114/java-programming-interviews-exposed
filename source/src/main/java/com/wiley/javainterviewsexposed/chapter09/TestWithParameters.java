package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestWithParameters {

    private final int a;
    private final int b;
    private final int expectedAddition;
    private final int expectedSubtraction;
    private final int expectedMultiplication;
    private final int expectedDivision;

    public TestWithParameters(final int a,
                              final int b,
                              final int expectedAddition,
                              final int expectedSubtraction,
                              final int expectedMultiplication,
                              final int expectedDivision) {
        this.a = a;
        this.b = b;
        this.expectedAddition = expectedAddition;
        this.expectedSubtraction = expectedSubtraction;
        this.expectedMultiplication = expectedMultiplication;
        this.expectedDivision = expectedDivision;
    }

    @Parameterized.Parameters
    public static List<Integer[]> parameters() {
        return new ArrayList<Integer[]>(1) {{
            add(new Integer[] {1, 2, 3, -1, 2, 0});
            add(new Integer[] {0, 1, 1, -1, 0, 0});
            add(new Integer[] {-11, 2, -9, -13, -22, -5});
        }};
    }

    @Test
    public void addNumbers() {
        assertEquals(expectedAddition, a + b);
    }

    @Test
    public void subtractNumbers() {
        assertEquals(expectedSubtraction, a - b);
    }

    @Test
    public void multiplyNumbers() {
        assertEquals(expectedMultiplication, a * b);
    }

    @Test
    public void divideNumbers() {
        assertEquals(expectedDivision, a / b);
    }
}
