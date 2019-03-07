package com.wiley.javainterviewsexposed.chapter10;

import org.junit.Test;

import java.util.ArrayList;

public class OutOfMemoryRunner {

    @Test
    public void outOfMemoryCrash() {
        final ArrayList<Long> longs = new ArrayList<>();
        while(true) {
            longs.add(System.currentTimeMillis());
        }
    }

    @Test
    public void stackOverflow() {
        stackOverflow();
    }
}
