package data_structure;

public abstract class SymbolTable<Key extends Comparable<Key>, Value> {

    public abstract void put(Key key, Value value);

    public abstract Value get(Key key);

    public abstract Value delete(Key key);

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public abstract int size();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract Key min();

    public abstract Key max();

    /**
     * Return a key that is the biggest among the keys no more than the key
     * @param key the key
     * @return a key
     */
    public abstract Key floor(Key key);

    /**
     * Return a key that is the smallest among the keys no less than the key
     * @param key the key as the floor
     * @return a key
     */
    public abstract Key ceiling(Key key);

    /**
     * Return the amount of keys that are lower than this key
     * @param key the key as the ceiling
     * @return the amount of lower keys
     */
    public abstract int rank(Key key);

    public abstract Key select(int k);

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public int size(Key low, Key high) {
        if (low.compareTo(high) < 0)
            return 0;
        else if (contains(high))
            return rank(high) - rank(low) + 1;
        else
            return rank(high) - rank(low);
    }

    public abstract Iterable<Key> keys(Key low, Key high);

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

}
