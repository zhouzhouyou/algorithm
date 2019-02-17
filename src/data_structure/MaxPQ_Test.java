package data_structure;

import java.util.Random;

public class MaxPQ_Test {
    public static void main(String[] args) {
        int size = 100000;
        MaxPQ<Integer> maxPQ = new MaxPQ<>(size);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            maxPQ.insert(random.nextInt());
        }
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}
