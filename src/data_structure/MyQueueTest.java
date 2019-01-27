package data_structure;

public class MyQueueTest {
    public static void main(String[] args) {
        int total = Integer.valueOf(args[0]);
        int step = Integer.valueOf(args[1]);

        MyQueue<Integer> myQueue = new MyQueue<>();
        for (int i = 0; i < total; i++) {
            myQueue.enqueue(i);
        }

        while (!myQueue.isEmpty()) {
            if (myQueue.size() <= step) {
                break;
            }
            System.out.println("deleting: " + myQueue.delete(step));
            System.out.println("===current queue size " + myQueue.size() + "===");
            myQueue = myQueue.getNewQueue(step);
            myQueue.forEach(e -> System.out.print(e + " "));
            System.out.println("\n===queue end===\n");
        }
    }
}
