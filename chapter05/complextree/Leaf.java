package com.wiley.javainterviewsexposed.chapter05.complextree;

public class Leaf<E extends Comparable> implements Tree<E> {

    private final Node<E> parent;

    public Leaf(Node<E> parent) {
        this.parent = parent;
    }

    @Override
    public boolean search(E toFind) {
        return false;
    }

    @Override
    public void insert(E toInsert) {
        if (toInsert.compareTo(parent.getValue()) < 0) {
            parent.setLeft(new Node<>(toInsert, new Leaf<>(parent), new Leaf<>(parent)));
        } else {
            parent.setRight(new Node<>(toInsert, new Leaf<>(parent), new Leaf<>(parent)));
        }
    }
}
