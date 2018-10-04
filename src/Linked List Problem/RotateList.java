public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode tail = head;
        ListNode tmp = head;
        while (tmp != null) {
            ++len;
            tail = tmp;
            tmp = tmp.next;
        }
        k = k % len;
        if (k == 0)
            return head;
        ListNode pre = head;
        for (int i = 1; i < len - k; ++i) {
            pre = pre.next;
        }
        ListNode newHead = pre.next;
        pre.next = null;
        tail.next = head;
        return newHead;
    }
}
