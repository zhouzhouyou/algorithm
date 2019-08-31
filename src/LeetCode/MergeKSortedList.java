package LeetCode;

public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = null, rear = null;
        while (true) {
            int minValue = Integer.MAX_VALUE;
            int location = 0;
            boolean flag = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                flag = false;
                ListNode node = lists[i];
                if (node.val < minValue) {
                    minValue = node.val;
                    location = i;
                }
            }
            ListNode node = lists[location];
            if (head == null) {
                head = node;
                rear = head;
            } else {
                rear.next = node;
                rear = rear.next;
            }
            if (flag) return head;
            lists[location] = lists[location].next;

        }
    }

    public void test() {
        ListNode first = new ListNode(1);
        first.next = new ListNode(4);
        first.next.next = new ListNode(5);

        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);

        ListNode third = new ListNode(2);
        third.next = new ListNode(6);

        ListNode[] listNodes = {first, second, third};
        ListNode node = mergeKLists(listNodes);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        mergeKSortedList.test();
    }

}
