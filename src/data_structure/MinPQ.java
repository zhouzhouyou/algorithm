package data_structure;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MinPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    @SuppressWarnings("unchecked")
    public MinPQ(Key[] a) {
        pq = (Key[]) new Comparable[a.length + 1];
        for (Key key : a) {
            insert(key);
        }
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key min() {
        return pq[1];
    }

    public Key delMin() {
        Key min = pq[1];
        exchange(1, N--);
        pq[N + 1] = null;
        sink(1);
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
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
