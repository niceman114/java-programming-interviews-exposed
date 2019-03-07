package com.wiley.javainterviewsexposed.chapter04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Mergesort {

    public static List<Integer> mergesort(final List<Integer> values) {
        if (values.size() < 2) {
            return values;
        }

        final List<Integer> leftHalf =
                values.subList(0, values.size() / 2);
        final List<Integer> rightHalf =
                values.subList(values.size() / 2, values.size());

        return merge(mergesort(leftHalf), mergesort(rightHalf));
    }

    private static List<Integer> merge(final List<Integer> left,
                                       final List<Integer> right) {
        int leftPtr = 0;
        int rightPtr = 0;

        final List<Integer> merged =
                new ArrayList<>(left.size() + right.size());

        while (leftPtr < left.size() && rightPtr < right.size()) {
            if (left.get(leftPtr) < right.get(rightPtr)) {
                merged.add(left.get(leftPtr));
                leftPtr++;
            } else {
                merged.add(right.get(rightPtr));
                rightPtr++;
            }
        }

        while (leftPtr < left.size()) {
            merged.add(left.get(leftPtr));
            leftPtr++;
        }

        while (rightPtr < right.size()) {
            merged.add(right.get(rightPtr));
            rightPtr++;
        }

        return merged;
    }

    @Test
    public void testMergesort() {
        final List<Integer> numbers = Arrays.asList(6, 4, 9, 5);
        final List<Integer> expected = Arrays.asList(4, 5, 6, 9);

        final List<Integer> actual = mergesort(numbers);
        assertEquals(expected, actual);
    }
}
