package com.wiley.javainterviewsexposed.chapter11;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.Assert.assertEquals;

public class Atomics {

    private static final Random random = new Random();
    private final   AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void atomicIntegers() throws InterruptedException {
        final Executor incrementor = Executors.newCachedThreadPool();
        incrementor.execute(new AtomicInc(atomicInteger));
        Thread.sleep(random.nextInt(3) * 1000);

        for (int i = 0; i < 10; i++) {
            synchronized (atomicInteger) {
                System.out.println(i);
                int randomIncrement = random.nextInt(5);
                final int value = atomicInteger.getAndAdd(randomIncrement);

                assertEquals(atomicInteger.get(), value + randomIncrement);
            }
        }

    }

    private static class AtomicInc implements Runnable {
        private final AtomicInteger atomicInteger;

        private AtomicInc(final AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            while(true) {
                atomicInteger.getAndAdd(random.nextInt(10));
            }
        }
    }
}
