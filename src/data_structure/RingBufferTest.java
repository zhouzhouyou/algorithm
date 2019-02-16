package data_structure;

import java.util.Random;

public class RingBufferTest {
    public static void main(String[] args) {
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(12);
        int i = 0;
        while (i < 12) {
            try {
                ringBuffer.put(i++);
            } catch (FullBuffer fullBuffer) {
                fullBuffer.printStackTrace();
            }
        }
        Random random = new Random((int) System.currentTimeMillis());
        while (i < 60) {
            try {
                int choice = random.nextInt();
                if (choice%2 == 0) {
                    ringBuffer.put(i++);
                    System.out.println("put, size: " + ringBuffer.size() + " i: " + i);
                } else {
                    System.out.println("get, size: " + ringBuffer.get());
                }
            } catch (FullBuffer | EmptyBuffer e) {
                if (e instanceof FullBuffer) {
                    System.out.println("FULL,  i: " + i);
                } else {
                    System.out.println("EMPTY, i: " + i);
                }
            }
        }

        System.out.println("i = " + i);
    }
}
