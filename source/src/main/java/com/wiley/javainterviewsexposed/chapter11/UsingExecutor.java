package com.wiley.javainterviewsexposed.chapter11;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class UsingExecutor {

    public static void main(String args[]) throws InterruptedException {
        final Executor executor = Executors.newCachedThreadPool();
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
    }
}
