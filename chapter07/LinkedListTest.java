package com.wiley.javainterviewsexposed.chapter07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LinkedListTest {

    @Test
    public void reverseLinkedList() {
        final LinkedList<String> three = new LinkedList<>("3", null);
        final LinkedList<String> two = new LinkedList<>("2", three);
        final LinkedList<String> one = new LinkedList<>("1", two);

        final LinkedList<String> reversed = LinkedList.reverse(one);

        assertEquals("3", reversed.getElement());
        assertEquals("2", reversed.getNext().getElement());
        assertEquals("1", reversed.getNext().getNext().getElement());
    }
}
