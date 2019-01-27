package data_structure;

public class MyDequeTest {
    public static void main(String[] args) {
        MyDeque<Integer> myDeque = new MyDeque<>();
        for (int i = 0; i < 10; i++) {
            myDeque.pushLeft(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(myDeque.popRight());
        }

        for (int i = 0; i < 10; i++) {
            myDeque.pushRight(i);
        }

        for (Integer x : myDeque) {
            System.out.print(x + " ");
        }
    }
}
