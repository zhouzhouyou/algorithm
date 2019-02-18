package data_structure;

public class MinPQ<Key extends Comparable<Key>> extends PriorityQueue<Key> {
    @SuppressWarnings("unchecked")
    public MinPQ(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public MinPQ(Key[] a) {
        keys = (Key[]) new Comparable[a.length + 1];
        for (Key key : a) {
            insert(key);
        }
    }

    public void insert(Key v) {
        keys[++N] = v;
        swim(N);
    }

    public Key min() {
        return keys[1];
    }

    public Key delMin() {
        Key min = keys[1];
        exchange(1, N--);
        keys[N + 1] = null;
        sink(1);
        return min;
    }

    private void swim(int k) {
        while (k > 1 && !less(k, k / 2)) {
            exchange(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j)) j++;
            if (!less(j, k)) break;
            exchange(k, j);
            k = j;
        }
    }
}
