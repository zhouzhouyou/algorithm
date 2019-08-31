package LeetCode;

public class RemoveEndNNodeOnePass {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode test() {
        ListNode head = new ListNode(1);
        ListNode rear = head;
        for (int i = 2; i < 6; i++) {
            rear.next = new ListNode(i);
            rear = rear.next;
        }
        return removeNthFromEnd(head, 2);
    }

    public static void main(String[] args) {
        RemoveEndNNodeOnePass pass = new RemoveEndNNodeOnePass();
        ListNode head = pass.test();
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
