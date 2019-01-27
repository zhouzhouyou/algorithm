package data_structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<T> implements Iterable<T>{
    private T[] stack;
    private int size;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack (int capacity) {
        stack = (T[]) new Object[
                capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T t) {
        if (size == stack.length) {
            resize(2*size);
        }
        stack[size++] = t;
    }

    public boolean isFull() {
        return size>=stack.length;
    }

    public T peek() {
        return stack[size-1];
    }

    public T pop() {
        T pop = stack[--size];
        stack[size] = null;
        if (size > 0 && size < stack.length/4) {
            resize(size/2);
        }
        return pop;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        T[] newStack = (T[]) new Object[max];
        if (size >= 0) System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<T> {
        private int i = size;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            return stack[--i];
        }
    }
}

