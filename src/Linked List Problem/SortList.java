public class SortList {
    // 归并排序实现O(NlogN)排序原始链表数据
    // 额外的空间为O(LogN),因为是递归调用，会有O(LogN)的函数调用栈
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这里的slow是最中间的数字
        prev.next = null; // 从链表中间斩断，然后递归调用

        // step 2. sort each half
        ListNode l1 = sortList(head); // 排序一head开头的list
        ListNode l2 = sortList(slow);

        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        // 新建一个dummy节点
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

}

