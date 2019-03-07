package com.wiley.javainterviewsexposed.chapter10;

import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertTrue;

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
