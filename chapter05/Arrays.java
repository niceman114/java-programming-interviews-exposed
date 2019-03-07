package com.wiley.javainterviewsexposed.chapter05;

import org.junit.Test;

import java.util.Random;

import static junit.framework.Assert.assertEquals;

public class Arrays {

    @Test
    public void arrayDefinitions() {
        final int[] integers = new int[3];
        final boolean[] bools = {false, true, true, false};
        final String[] strings = new String[]{"one", "two"};

        final Random r = new Random();
        final String[] randomArrayLength = new String[r.nextInt(100)];
    }

    @Test
    public void arrayCopy() {
        int[] integers = {0, 1, 2, 3, 4};

        int[] newIntegersArray = new int[integers.length + 1];
        System.arraycopy(integers, 0, newIntegersArray, 0, integers.length);
        integers = newIntegersArray;
        integers[5] = 5;

        assertEquals(5, integers[5]);
    }
}
