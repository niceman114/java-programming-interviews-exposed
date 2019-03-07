package com.wiley.javainterviewsexposed.chapter10;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WeakReferenceStackTest {

    @Test
    public void weakReferenceStackManipulation() {
        final WeakReferenceStack<ValueContainer> stack = new WeakReferenceStack<>();

        final ValueContainer expected = new ValueContainer("Value for the stack");
        stack.push(new ValueContainer("Value for the stack"));

        ValueContainer peekedValue = stack.peek();
        assertEquals(expected, peekedValue);
        assertEquals(expected, stack.peek());
        peekedValue = null;
        System.gc();
        assertNull(stack.peek());
    }

}
