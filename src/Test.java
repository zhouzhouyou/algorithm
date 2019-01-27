import data_structure.FixedCapacityStack;

public class Test {
    private static int getTan(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        }
        int[] t = new int[N+1];
        t[0] = 1;
        for (int i = 1; i <= N; i++) {
            t[i] = t[i-1]*i;
        }
        return t[N];

    }

    public static void main(String[] args) {
        System.out.println(getTan(15));
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        for (int a: stack) {
            System.out.println(a);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(stack.pop());
        }
    }
}
