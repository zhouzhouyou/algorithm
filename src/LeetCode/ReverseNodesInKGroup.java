package LeetCode;

public class ReverseNodesInKGroup {
    /*
    https://leetcode.com/problems/reverse-nodes-in-k-group/
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode temp = head;
        for (int i = 1; i < k; i++) {
            temp = temp.next;
            if (temp == null) return head;
        }
        temp.next = reverseKGroup(temp.next, k);
        temp = head;
        ListNode pre = head, current;
        for (int i = 1; i < k; i++) {
            current = temp.next;
            temp.next = current.next;
            current.next = pre;
            head = current;
            pre = head;
        }
        return head;
    }

    public void test() {
        ListNode[] listNodes = {new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4), new ListNode(5)};
        for (int i = 1; i < listNodes.length; i++) {
            listNodes[i-1].next = listNodes[i];
        }

        ListNode head = reverseKGroup(listNodes[0], 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup kGroup = new ReverseNodesInKGroup();
        kGroup.test();
    }
}
