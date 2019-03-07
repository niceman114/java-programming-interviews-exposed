package com.wiley.javainterviewsexposed.chapter10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecursionAndIteration {

    @Test
    public void listReversals() {
        final List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> expectedList = Arrays.asList(5, 4, 3, 2, 1);

        assertEquals(expectedList.size(), reverseRecursive(givenList).size());
        assertEquals(expectedList.size(), reverseIterative(givenList).size());
    }

    private List<Integer> reverseRecursive(List<Integer> list) {
        if (list.size() <= 1) { return list; }
        else {
            List<Integer> reversed = new ArrayList<>();
            reversed.add(list.get(list.size() - 1));
            reversed.addAll(reverseRecursive(list.subList(0, list.size() - 1)));
            return reversed;
        }
    }

    private List<Integer> reverseIterative(final List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            final int tmp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, tmp);
        }

        return list;
    }
}
