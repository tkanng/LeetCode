public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow节点就是一head开头的链表的中间节点
        // 1,2,3 slow ==> 为2  pre 为1
        // 1,2,3,4 slow ===> 为3  pre 为2
        // 所以 len[slow, tail] - len[head,prev]<=1 至多
        // 其中prev.next == slow
        TreeNode root = new TreeNode(slow.val);
        prev.next = null; // 切断链表
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
