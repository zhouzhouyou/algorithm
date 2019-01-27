package data_structure;

import java.util.Iterator;

public class MyDeque<T> implements Iterable<T> {
    private Node left;
    private Node right;
    private int N;

    private class Node {
        T t;
        Node left;
        Node right;

        Node(T t) {
            this.t = t;
        }

        void setRelation(Node left, Node right) {
            this.right = right;
            this.left = left;
        }
    }

    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    public void pushLeft(T t) {
        Node newLeft = new Node(t);
        if (isEmpty()) {
            left = newLeft;
            right = newLeft;
            left.setRelation(null, right);
            right.setRelation(left, null);
        } else {
            left.left = newLeft;
            newLeft.right = left;
            left = newLeft;
        }
        N++;
    }

    public void pushRight(T t) {
        Node newRight = new Node(t);
        if (isEmpty()) {
            right = newRight;
            left = newRight;
            right.setRelation(left, null);
            left.setRelation(null, right);
        } else {
            right.right = newRight;
            newRight.left = right;
            right = newRight;
        }
        N++;
    }

    public T popLeft() {
        if (left == null) {
            left = right;
        }
        T out = left.t;
        left = left.right;
        N--;
        return out;
    }

    public T popRight() {
        T out = right.t;
        right = right.left;
        N--;
        return out;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyDequeIterator();
    }

    private class MyDequeIterator implements Iterator<T> {
        Node current = left;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T out = current.t;
            current = current.right;
            return out;
        }
    }
}
