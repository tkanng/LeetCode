public class MidNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i < 9; ++i) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        new MidNode().midNode(head);
    }

    public ListNode midNode(ListNode head) {
        // 1,2,3 返回2
        // 1,2,3,4 返回3
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow;

    }
}
