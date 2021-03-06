package com.wiley.javainterviewsexposed.chapter11;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.Assert.assertEquals;

public class AtomicSharedState {

    @Test
    public void atomicSharedState() {
        final ExecutorService executorService =
                Executors.newCachedThreadPool();

        final AtomicCounter c = new AtomicCounter();
        executorService.execute(new CounterSetter(c));

        final int value = c.getNumber().incrementAndGet();
        assertEquals(101, value);
    }

    private static class CounterSetter implements Runnable {
        private final AtomicCounter counter;

        private CounterSetter(AtomicCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while(true) {
                counter.getNumber().set(100);
            }
        }
    }
}

