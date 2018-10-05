public class PartitionList {
    public ListNode partition(ListNode node, int x) {
        ListNode smallHead = null, smallTail = null;
        ListNode biggerEqualHead = null, biggerEqualTail = null;
        while (node != null) {
            ListNode tmp = node.next;
            if (node.val < x) {
                if (smallHead == null) {
                    smallHead = node;
                    smallTail = node;
                } else {
                    smallTail.next = node;
                    smallTail = node;
                }
            } else {
                if (biggerEqualHead == null) {
                    biggerEqualHead = node;
                    biggerEqualTail = node;
                } else {
                    biggerEqualTail.next = node;
                    biggerEqualTail = node;
                }
            }
            node = tmp;
        }
        if (biggerEqualTail != null) biggerEqualTail.next = null;
        if (smallTail != null) smallTail.next = null;
        if (smallTail != null) {
            smallTail.next = biggerEqualHead;
            return smallHead;
        } else {
            return biggerEqualHead;
        }
    }


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        // 从第三个节点开始
        ListNode oddHead = head;
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        ListNode tmp = head.next.next;
        int no = 2;
        while (tmp != null) {
            no++;
            ListNode next = tmp.next;
            if (no % 2 == 0) {
                // 第偶数个节点
                evenTail.next = tmp;
                evenTail = evenTail.next;
            } else {
                oddTail.next = tmp;
                oddTail = oddTail.next;
            }
            tmp = next;
        }
        evenTail.next = null;
        oddTail.next = evenHead;
        return oddHead;
    }
}





