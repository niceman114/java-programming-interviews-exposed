package com.wiley.javainterviewsexposed.chapter11;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static junit.framework.Assert.assertEquals;

public class LockedSharedState {

    @Test
    public void lockedSharedState() {
        final ExecutorService executorService =
                Executors.newCachedThreadPool();

        final SimpleCounter c = new SimpleCounter();
        executorService.execute(new CounterSetter(c));

        synchronized (c) {
            c.setNumber(200);
            assertEquals(200, c.getNumber());
        }
    }

    private static class CounterSetter implements Runnable {
        private final SimpleCounter counter;

        private CounterSetter(SimpleCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (counter) {
                    counter.setNumber(100);
                }
            }
        }
    }
}
