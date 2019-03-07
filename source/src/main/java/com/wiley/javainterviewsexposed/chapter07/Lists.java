package com.wiley.javainterviewsexposed.chapter07;

import java.util.ArrayList;
import java.util.List;

public class Lists {

    public static List<Integer> addOne(final List<Integer> numbers) {
        final ArrayList<Integer> toReturn = new ArrayList<>(numbers.size());
        for (final Integer number : numbers) {
            toReturn.add(number + 1);
        }

        return toReturn;
    }

    public static List<Integer> updateList(final List<Integer> numbers,
                                           final IntegerOperation op) {
        final ArrayList<Integer> toReturn = new ArrayList<>(numbers.size());
        for (final Integer number : numbers) {
            toReturn.add(op.performOperation(number));
        }

        return toReturn;
    }

    public static <A, B> List<B> mapList(final List<A> values,
                                         final GenericOperation<A, B> op) {
        final ArrayList<B> toReturn = new ArrayList<>(values.size());
        for (final A a : values) {
            toReturn.add(op.performOperation(a));
        }

        return toReturn;
    }
}

