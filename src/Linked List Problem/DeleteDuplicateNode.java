public class DeleteDuplicateNode {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        // 保证head后至少还有一个节点
        boolean isRepeated = false;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (nextNode.val == head.val) {
                isRepeated = true;
            } else {
                break;
            }
            nextNode = nextNode.next;
        }
        if (isRepeated) {
            return deleteDuplicates(nextNode);
        } else {
            head.next = deleteDuplicates(nextNode);
            return head;
        }
    }

}
