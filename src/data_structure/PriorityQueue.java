package data_structure;

public abstract class PriorityQueue<Key extends Comparable<Key>> {
    Key[] keys;
    int N;


    boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    void exchange(int i, int j) {
        Key t = keys[i];
        keys[i] = keys[j];
        keys[j] = t;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

}
