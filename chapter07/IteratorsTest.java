package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class IteratorsTest {

    @Test
    public void multipleIterators() {
        final Iterator<Integer> a = Arrays.asList(1, 2, 3, 4, 5).iterator();
        final Iterator<Integer> b = Arrays.asList(6).iterator();
        final Iterator<Integer> c = new ArrayList<Integer>().iterator();
        final Iterator<Integer> d = new ArrayList<Integer>().iterator();
        final Iterator<Integer> e = Arrays.asList(7, 8, 9).iterator();

        final Iterator<Integer> singleIterator = Iterators.singleIterator(Arrays.asList(a, b, c, d, e));

        assertTrue(singleIterator.hasNext());
        for (Integer i = 1; i < 9; i++) {
            assertEquals(i, singleIterator.next());
        }
        assertFalse(singleIterator.hasNext());
    }
}
