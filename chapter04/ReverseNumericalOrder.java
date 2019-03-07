package com.wiley.javainterviewsexposed.chapter04;

import java.util.Comparator;

public class ReverseNumericalOrder implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    // equals omitted
}
