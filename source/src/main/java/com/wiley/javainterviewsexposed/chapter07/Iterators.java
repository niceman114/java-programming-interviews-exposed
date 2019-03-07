package com.wiley.javainterviewsexposed.chapter07;

import java.util.Iterator;
import java.util.List;

public class Iterators {

    public static class ListIterator<T> implements Iterator<T> {

        private final Iterator<Iterator<T>> listIterator;
        private Iterator<T> currentIterator;

        public ListIterator(List<Iterator<T>> iterators) {
            this.listIterator = iterators.iterator();
            this.currentIterator = listIterator.next();
        }

        @Override
        public boolean hasNext() {
            if(!currentIterator.hasNext()) {
                if (!listIterator.hasNext()) {
                    return false;
                }

                currentIterator = listIterator.next();
                hasNext();
            }

            return true;
        }

        @Override
        public T next() {
            hasNext();
            return currentIterator.next();
        }

        @Override
        public void remove() {
            hasNext();
            currentIterator.remove();
        }
    }

    public static <T> Iterator<T> singleIterator(final List<Iterator<T>> iteratorList) {
        return new ListIterator<>(iteratorList);
    }
}
