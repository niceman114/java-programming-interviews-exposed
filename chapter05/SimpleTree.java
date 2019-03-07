package com.wiley.javainterviewsexposed.chapter05;

public class SimpleTree<E extends Comparable> {
    private E value;
    private SimpleTree<E> left;
    private SimpleTree<E> right;

    public SimpleTree(E value, SimpleTree<E> left, SimpleTree<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E getValue() {
        return value;
    }

    public SimpleTree<E> getLeft() {
        return left;
    }

    public SimpleTree<E> getRight() {
        return right;
    }

    public boolean search(final E toFind) {
        if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) < 0 && left != null) {
            return left.search(toFind);
        }

        return right != null && right.search(toFind);
    }

    public void insert(final E toInsert) {
        if (toInsert.compareTo(value) < 0) {
            if (left == null) {
                left = new SimpleTree<>(toInsert, null, null);
            } else {
                left.insert(toInsert);
            }
        } else {
            if (right == null) {
                right = new SimpleTree<>(toInsert, null, null);
            } else {
                right.insert(toInsert);
            }
        }
    }
}
