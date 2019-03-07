package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SimpleJUnitExpectations {

    @Test
    public void assertionWithMessage() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        assertTrue("The list is not empty", numbers.isEmpty());
    }

    @Test
    public void assertionWithoutMessage() {
        final List<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        assertTrue(numbers.isEmpty());
    }

    @Test
    public void assertionEqualsWithoutMessage() {
        assertEquals(1, 2);
    }
}
