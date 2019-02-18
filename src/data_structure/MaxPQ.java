package data_structure;

public class MaxPQ<Key extends Comparable<Key>> extends PriorityQueue<Key>{
    @SuppressWarnings("unchecked")
    public MaxPQ(int capacity) {
        keys = (Key[]) new Comparable[capacity + 1];
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] a) {
        keys = (Key[]) new Comparable[a.length + 1];
        for (Key key : a) {
            insert(key);
        }
    }

    public void insert(Key v) {
        keys[++N] = v;
        swim(N);
    }

    public Key max() {
        return keys[1];
    }

    public Key delMax() {
        Key max = keys[1];
        exchange(1, N--);
        keys[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }
}
