package data_structure;

import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
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

    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.t = t;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public T dequeue() {
        T t = first.t;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return t;
    }

    private Node getNode(int index) {
        if (index >= size()) {
            return null;
        }
        if (index == 0) {
            return first;
        }
        if (index == size() - 1) {
            return last;
        }
        int counter = 0;
        Node current = first;
        while (current.next != null) {
            if (counter++ == index) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    public T delete(int location) {
        if (location >= size()) {
            return null;
        }
        if (location == 0) {
            return dequeue();
        }
        Node left = getNode(location-1);
        assert left != null;
        Node target = left.next;
        left.next = target.next;
        N--;
        return target.t;
    }

    public MyQueue<T> getNewQueue(int location) {
        if (location != 0 && location < size()) {
            Node newLast = getNode(location-1);
            assert newLast != null;
            Node newStart = newLast.next;
            last.next = first;
            first = newStart;
            last = newLast;
            last.next = null;
        }
        return this;
    }

    public void reverse() {
        MyStack<T> myStack = new MyStack<>();
        for (T t: this) {
            myStack.push(t);
        }
        while (!isEmpty()) {
            dequeue();
        }
        for (T t: myStack) {
            enqueue(t);
        }
    }
}
