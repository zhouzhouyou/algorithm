package LeetCode;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, rear = null;
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                if (l1 == null) rear.next = l2;
                else rear.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    rear = head;
                } else {
                    rear.next = l1;
                    rear = rear.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    rear = head;
                } else {
                    rear.next = l2;
                    rear = rear.next;
                }
                l2 = l2.next;
            }
        }
        return head;
    }
}
