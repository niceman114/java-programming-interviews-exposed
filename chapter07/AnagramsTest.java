package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class AnagramsTest {

    @Test
    public void simpleAnagramLookup() {
        final List<String> words = Arrays.asList(
                "own",
                "won",
                "alert",
                "later",
                "alter"
        );

        final Anagrams anagrams = new Anagrams(words);

        assertEquals(0, anagrams.getAnagrams("invalid").size());
        assertEquals(Arrays.asList("own", "won"), anagrams.getAnagrams("now"));
    }
}
