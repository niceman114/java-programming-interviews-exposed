package com.wiley.javainterviewsexposed.chapter05;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Maps {

    @Test
    public void overwriteKey() {
        final Map<String, String> preferences = new HashMap<>();
        preferences.put("like", "jacuzzi");
        preferences.put("dislike", "steam room");

        assertEquals("jacuzzi", preferences.get("like"));

        preferences.put("like", "sauna");

        assertEquals("sauna", preferences.get("like"));
    }

    @Test
    public void treeMapTraversal() {
        final Map<Integer, String> counts = new TreeMap<>();
        counts.put(4, "four");
        counts.put(1, "one");
        counts.put(3, "three");
        counts.put(2, "two");

        final Iterator<Integer> keys = counts.keySet().iterator();
        assertEquals(Integer.valueOf(1), keys.next());
        assertEquals(Integer.valueOf(2), keys.next());
        assertEquals(Integer.valueOf(3), keys.next());
        assertEquals(Integer.valueOf(4), keys.next());
        assertFalse(keys.hasNext());
    }

    @Test
    public void linkedHashMapTraversal() {
        final Map<Integer, String> counts = new LinkedHashMap<>();
        counts.put(4, "four");
        counts.put(1, "one");
        counts.put(3, "three");
        counts.put(2, "two");

        final Iterator<Integer> keys = counts.keySet().iterator();
        assertEquals(Integer.valueOf(4), keys.next());
        assertEquals(Integer.valueOf(1), keys.next());
        assertEquals(Integer.valueOf(3), keys.next());
        assertEquals(Integer.valueOf(2), keys.next());
        assertFalse(keys.hasNext());
    }
}
