public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode head2 = reverseList(slow, null, null);
        ListNode tmp = head;
        while (tmp != null) {
            ListNode next = tmp.next;
            if (next == null) {
                tmp.next = head2;
            } else {
                tmp.next = head2;
                head2 = head2.next;
                tmp.next.next = next;
            }
            tmp = next;
        }

    }

    public ListNode reverseList(ListNode head, ListNode newHead, ListNode tailNext) {
        // tailNext 是想要反转链表中最后一个元素的下一个节点。所以，反转整个链表的话，需要将tailNext置为null
        if (head == tailNext)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head, tailNext);
    }


}
