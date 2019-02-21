package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Comparable[capacity];
        N = 0;
    }

    @Override
    public void put(Key key, Value value) {
        //if the value is null, delete the key
        if (value == null) {
            delete(key);
            return;
        }

        int position = rank(key);
        if (position < N && keyExist(position, key)) {
            //if the key already exists
            values[position] = value;
            return;
        }

        //out of boundary
        if (N == keys.length)
            resize(2 * N);

        // if the key doesn't exist
        // move from arrays[position] to arrays[N] to the next one
        for (int i = N; i > position; i--) {
            keys[i] = keys[i-1];
            values[i] = values[i-1];
        }

        keys[position] = key;
        values[position] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty())
            return null;

        int position = rank(key);
        if (position < N && keyExist(position, key))
            return values[position];

        return null;
    }

    @Override
    public Value delete(Key key) {
        int position = rank(key);

        // if the key doesn't exist
        if (position < N && !keyExist(position, key))
            return null;

        Value value = values[position];
        // if the arrays are too large
        if (N < keys.length / 4)
            resize(keys.length / 2);

        // move from arrays[position] to the last item to the previous one
        for (int i = position; i < N - 1; i++) {
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }

        N--;
        return value;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public Key floor(Key key) {
        int position = rank(key);

        // if the key exists
        if (position < N && keyExist(position, key))
            return keys[position];

        // if the key doesn't exist
        return keys[position-1];
    }

    @Override
    public Key ceiling(Key key) {
        int position = rank(key);
        return keys[position];
    }

    @Override
    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int middle = low + (high - low) >>> 1;
            int cmp = key.compareTo(keys[middle]);
            if (cmp < 0)
                high = middle - 1;
            else if (cmp > 0)
                low = middle + 1;
            else
                return middle;
        }
        return low;
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        List<Key> keyList = new ArrayList<>(N);
        keyList.addAll(Arrays.asList(keys).subList(0, N));
        return keyList;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Key[] newKeys = (Key[]) new Comparable[newCapacity];
        Value[] newValues = (Value[]) new Comparable[newCapacity];
        if (N >= 0) System.arraycopy(keys, 0, newKeys, 0, N);
        if (N >= 0) System.arraycopy(values, 0, newValues, 0, N);
        keys = newKeys;
        values = newValues;
    }

    private boolean keyExist(int k, Key key) {
        return keys[k].compareTo(key) == 0;
    }
}
