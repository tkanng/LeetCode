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
}
