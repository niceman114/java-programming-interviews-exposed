package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ListTest {

    @Test
    public void positiveList() {
        final List<Integer> numbers = Arrays.asList(4, 7, 2, -2, 8, -5, -7);
        final List<Integer> expected = Arrays.asList(4, 7, 2, 2, 8, 5, 7);

        final List<Integer> actual = Lists.updateList(numbers, new IntegerOperation() {
            @Override
            public Integer performOperation(Integer value) {
                return Math.abs(value);
            }
        });

        assertEquals(expected, actual);
    }

    @Test
    public void stringLengths() {
        final List<String> strings = Arrays.asList(
                "java", "programming", "interviews", "exposed"
        );
        final List<Integer> expected = Arrays.asList(4, 11, 10, 7);
        final List<Integer> actual = Lists.mapList(strings, new StringLengthOperation());
        assertEquals(expected, actual);
    }
}
