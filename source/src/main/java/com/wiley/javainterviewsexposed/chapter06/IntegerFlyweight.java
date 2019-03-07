package com.wiley.javainterviewsexposed.chapter06;

import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class IntegerFlyweight {

    @Test
    public void sameIntegerInstances() {
        final Integer a = Integer.valueOf(56);
        final Integer b = Integer.valueOf(56);

        assertSame(a, b);

        final Integer c = Integer.valueOf(472);
        final Integer d = Integer.valueOf(472);

        assertNotSame(c, d);
    }
}
