package data_structure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IndexMinPQ<Key extends Comparable<Key>> extends PriorityQueue<Key> {
    private int[] elements;
    private int[] indexes;
    //indexes represents the logical structure of a min heap, indexes[1] is the least element
    //elements[indexes[i]] = indexes[elements[i]] = i
    //elements[indexes[i]] stores the i-th added element's indexes in keys[]

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int capacity) {
        keys = (Key[]) new Comparable[++capacity];
        elements = new int[capacity];
        indexes = new int[capacity];
        Arrays.fill(elements, -1);
    }

    boolean more(int i, int j) {
        return keys[indexes[i]].compareTo(keys[indexes[j]]) > 0;
    }

    public boolean contains(int k) {
        return elements[k] != -1;
    }

    public void insert(int k, Key key) {
        if (!contains(k)) {
            N++;
            indexes[N] = k;
            elements[k] = N;
            keys[k] = key;
            swim(N);
        }
    }

    public void change(int k, Key key) {
        if (!contains(k)) {
            throw new IllegalArgumentException("no such elements to change");
        } else {
            keys[elements[k]] = key;
            swim(k);
            sink(k);
        }
    }

    public void delete(int k) {
        if (!contains(k)) {
            throw new IllegalArgumentException("no such elements to delete");
        } else {
            int index = elements[k];
            exchange(index, N--);
            swim(index);
            sink(index);
            keys[k] = null;
            elements[k] = -1;
        }
    }

    public Key min() {
        return keys[indexes[1]];
    }

    public int minIndex() {
        return indexes[1];
    }

    public int delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty queue");
        }
        int index = minIndex();
        exchange(1, N--);
        sink(1);
        keys[index] = null;
        elements[index] = -1;
        return index;
    }

    @Override
    void exchange(int i, int j) {
        int indexI = indexes[i];
        int indexJ = indexes[j];
        indexes[i] = indexJ;
        indexes[j] = indexI;
        elements[indexJ] = i;
        elements[indexI] = j;
    }

    private void swim(int k) {
        while (k > 1 && more(k / 2, k)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && more(j, j + 1)) j++;
            if (!more(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }



}
