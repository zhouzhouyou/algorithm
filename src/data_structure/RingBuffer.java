package data_structure;

import java.util.Iterator;

public class RingBuffer<Item> implements Iterable<Item> {
    private Item[] buffer;
    private int capacity = 0;
    private int first = 0;
    private int last = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public RingBuffer(int capacity) {
        this.capacity = capacity;
        buffer = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public int size() {
        return size;
    }

    public void put(Item item) throws FullBuffer{
        if (isFull()) {
            throw new FullBuffer("capacity: " + capacity + " is full");
        }

        buffer[last++] = item;
        if (last == 12) {
            last = 0;
        }
        size++;
    }

    public Item get() throws EmptyBuffer{
        if (isEmpty()) {
            throw new EmptyBuffer("first and last are both located at " + first);
        }

        Item item = buffer[first++];
        if (first == 12) {
            first = 0;
        }
        size--;
        return item;
    }

    private class RingBufferIterator implements Iterator<Item> {
        private int current = first;

        @Override
        public boolean hasNext() {
            return current!=last;
        }

        @Override
        public Item next() {
            return buffer[current];
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RingBufferIterator();
    }
}

class FullBuffer extends Exception {
    FullBuffer(String message) {
        super(message);
    }
}

class EmptyBuffer extends Exception {
    EmptyBuffer(String message) {
        super(message);
    }
}



