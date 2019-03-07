package com.wiley.javainterviewsexposed.chapter07;

public class Strings {

    public static String reverse(final String s) {
        final StringBuilder builder = new StringBuilder(s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static String inPlaceReverse(final String s) {
        final StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length() / 2; i++) {
            final char tmp = builder.charAt(i);
            final int otherEnd = builder.length() - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd));
            builder.setCharAt(otherEnd, tmp);
        }

        return builder.toString();
    }

    public static boolean isPalindrome(final String s) {
        final String toCheck = s.toLowerCase();
        int left = 0;
        int right = toCheck.length() - 1;

        while (left <= right) {
            while(left < toCheck.length() &&
                    !Character.isLetter(toCheck.charAt(left))) {
                left++;
            }
            while(right > 0 && !Character.isLetter(toCheck.charAt(right))) {
                right--;
            }
            if (left > toCheck.length() || right < 0) {
                return false;
            }

            if (toCheck.charAt(left) != toCheck.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean strictPalindrome(final String s) {
        return s.equals(reverse(s));
    }
}
