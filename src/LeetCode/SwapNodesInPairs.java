package LeetCode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p = fakeHead;
        while (true) {
            ListNode swap1 = p.next;
            if (swap1 == null) break;
            ListNode swap2 = swap1.next;
            if (swap2 == null) break;
            p.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            p = swap1;
        }
        return fakeHead.next;
    }


    public void test() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;

        ListNode head = swapPairs(one);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.test();
    }
}
