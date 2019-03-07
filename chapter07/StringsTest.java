package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;

public class StringsTest {

    @Test
    public void reverse() {
        final String s = "Hello";
        assertEquals("olleH", Strings.reverse(s));
    }

    @Test
    public void reverseInPlace() {
        final String s = "Hello";
        assertEquals("olleH", Strings.inPlaceReverse(s));
    }

    @Test
    public void palindromeCheck() {
        assertTrue(Strings.isPalindrome("eve"));
        assertTrue(Strings.isPalindrome("level"));
        assertTrue(Strings.isPalindrome("Top spot"));
        assertFalse(Strings.isPalindrome("not a palindrome"));
    }
}
