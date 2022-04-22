package sort;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = sortLinkedList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // get mid -> mergesort left and right part recursive -> minimum case: 1 or 0 ListNode
    // sort when merging

    private static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = mergesort(head);

        return result;
    }

    private static ListNode mergesort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode mid = getMid(node);
        ListNode left = node;
        ListNode right= mid.next;
        mid.next = null;

        ListNode lHead = mergesort(left);
        ListNode rHead = mergesort(right);

        return merge(lHead, rHead);
    }

    private static ListNode getMid(ListNode node) {
        ListNode slow = new ListNode(0);
        ListNode fast = new ListNode(0);
        slow.next = node;
        fast.next = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = new ListNode(h1.val);
                h1 = h1.next;
            } else {
                cur.next = new ListNode(h2.val);
                h2 = h2.next;
            }
            cur = cur.next;
        }

        while (h1 != null) {
            cur.next = new ListNode(h1.val);
            h1 = h1.next;
            cur = cur.next;
        }

        while (h2 != null) {
            cur.next = new ListNode(h2.val);
            h2 = h2.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
