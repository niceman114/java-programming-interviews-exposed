package com.wiley.javainterviewsexposed.chapter05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleTreeTest {

    private SimpleTree<Integer> root;

    @Before
    public void createSampleTree() {
        final SimpleTree<Integer> t1 = new SimpleTree<>(1, null, null);
        final SimpleTree<Integer> t5 = new SimpleTree<>(5, null, null);

        final SimpleTree<Integer> t3 = new SimpleTree<>(5, t1, t5);
        final SimpleTree<Integer> t9 = new SimpleTree<>(9, null, null);

        root = new SimpleTree<>(7, t3, t9);

    }

    @Test
    public void search() {
        assertTrue(root.search(7));
        assertFalse(root.search(70));
    }

    @Test
    public void insert() {
        root.insert(10);
        assertTrue(root.search(10));
        assertEquals(Integer.valueOf(10), root.getRight().getRight().getValue());
    }

    @Test
    public void createTree() {
        final SimpleTree<Integer> root = new SimpleTree<>(7, null, null);
        root.insert(3);
        root.insert(9);
        root.insert(10);
        assertTrue(root.search(10));
        assertEquals(Integer.valueOf(10), root.getRight().getRight().getValue());
    }

    @Test
    public void linkedListTree() {
        final SimpleTree<Integer> root = new SimpleTree<>(1, null, null);
        root.insert(2);
        root.insert(3);
        root.insert(4);
        root.insert(5);

    }
}
