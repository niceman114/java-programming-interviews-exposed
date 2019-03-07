package com.wiley.javainterviewsexposed.chapter04;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinarySearch {

    public static boolean binarySearch(final List<Integer> numbers,
                                       final Integer value) {
        if (numbers.isEmpty()) {
            return false;
        }

        final Integer comparison = numbers.get(numbers.size() / 2);
        if (value.equals(comparison)) {
            return true;
        }

        if (value < comparison) {
            return binarySearch(
                    numbers.subList(0, numbers.size() / 2),
                    value);
        } else {
            return binarySearch(
                    numbers.subList(numbers.size() / 2 + 1, numbers.size()),
                    value);
        }
    }

    @Test
    public void testBinarySearch() {
        assertTrue(binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 4));
        assertFalse(binarySearch(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 14));
    }
}
