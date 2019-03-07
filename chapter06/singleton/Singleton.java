package com.wiley.javainterviewsexposed.chapter06.singleton;

public class Singleton {

    private static Singleton INSTANCE;

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

    public void singletonMethod() {
        // operations here
    }
}
