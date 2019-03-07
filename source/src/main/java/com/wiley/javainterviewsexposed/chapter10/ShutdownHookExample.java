package com.wiley.javainterviewsexposed.chapter10;

import org.junit.Test;

import java.util.Date;

public class ShutdownHookExample {

    @Test
    public void addShudownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println(
                        "Shutting down JVM at time: " + new Date());
            }
        });
    }
}
