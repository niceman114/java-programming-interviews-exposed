package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestExample {

    @Test
    public void useHamcrest() {
        final Integer a = 400;
        final Integer b = 100;

        assertThat(a, is(notNullValue()));
        assertThat(a, is(equalTo(400)));
        assertThat(a - b, is(greaterThan(0)));
    }
}
