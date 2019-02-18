package data_structure;

import java.util.Random;

public class IndexMinPQTest {
    public static void main(String[] args) {
        IndexMinPQ<Integer> minPQ = new IndexMinPQ<>(20);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(20);
            minPQ.insert(index, random.nextInt());
        }
        System.out.println(minPQ.size());
        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.min());
            minPQ.delMin();
        }
    }
}
