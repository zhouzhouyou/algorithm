package data_structure;

import java.util.Iterator;

public class MyStack<T> implements Iterable<T>{
    private Node first;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }
    }

    private class Node {
        T t;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node old = first;
        first = new Node();
        first.t = t;
        first.next = old;
        N++;
    }

    public T peek() {
        return first.t;
    }

    public T pop() {
        T t = first.t;
        first = first.next;
        N--;
        return t;
    }

    public static <T> MyStack<T> copy(MyStack<T> source) {
        MyStack<T> temp = new MyStack<>();
        MyStack<T> copy = new MyStack<>();
        for (T t : source) {
            temp.push(t);
        }
        for (T t : temp) {
            copy.push(t);
        }
        return copy;
    }
}
