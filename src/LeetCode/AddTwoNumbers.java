package LeetCode;

public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = new ListNode(0);
        ListNode p = out;
        while (l1 != null && l2 != null) {
            p.next = new ListNode(l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        } else if (l2 != null) {
            p.next = l2;
        }

        p = out;
        while (p != null) {
            if (p.val >= 10) {
                p.val -= 10;
                if (p.next != null)
                    p.next.val++;
                else
                    p.next = new ListNode(1);
            }
            p = p.next;
        }
        return out.next;
    }

    public void test() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3.val);
    }

    public static void main(String[] args) {
        AddTwoNumbers add = new AddTwoNumbers();
        add.test();
    }
}
