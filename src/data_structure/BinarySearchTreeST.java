package data_structure;

public class BinarySearchTreeST<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null)
            return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else x.value = value;
        x.count = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        Node x = root;
        while (x!=null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x.value;
        }
        return null;
    }

    @Override
    public Value delete(Key key) {
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.count;
    }

    @Override
    public Key min() {
        Node x = root;
        while (x.left != null)
            x = x.left;
        return x.key;
    }

    @Override
    public Key max() {
        Node x = root;
        while (x.right != null)
            x = x.right;
        return x.key;
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            // no key is less than key
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            // search the left, because all right keys are greater
            return floor(node.left, key);
        else if (cmp == 0)
            // equal the key
            return node;
        // key os greater than node.key, so it could locates at the right
        Node f = floor(node.right, key);
        if (f == null)
            return node;
        // if there are right keys that are smaller than the key, they must be greater than left keys
        return f;
    }

    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0)
            return ceiling(node.right, key);
        if (cmp == 0)
            return node;
        Node f = ceiling(node.left, key);
        if (f == null)
            return node;
        return f;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp > 0)
            return size(node.left) + rank(node.right, key) + 1;
        else if (cmp == 0)
            return size(node.right);
        return rank(node.left, key);
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return null;
    }
}
