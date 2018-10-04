import java.util.Stack;

public class ReverseList {

    //用Stack实现
    public ListNode reverseList1(ListNode first) {
        if (first == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while (first != null) {
            stack.push(first);
            first = first.next;
        }
        ListNode head = stack.pop();
        ListNode tmp = head;
        while (!stack.isEmpty()) {
            tmp.next = stack.pop();
            tmp = tmp.next;
        }
        return head;
    }

    public ListNode reverseList2(ListNode node) {
        if (node == null) return null;// 节点数为0
        if (node.next == null) return node; // 节点数为1
        if (node.next.next == null) {  // 节点数为2
            ListNode head = node.next;
            head.next = node;
            node.next = null;
            return head;
        }
        // 链表节点个数>=3
        ListNode p = node;
        ListNode q = node.next;
        p.next = null;

        while (q.next != null) {
            ListNode r = q.next; // 辅助节点，记录链表的下一个节点
            q.next = p;
            p = q;
            q = r;
        }
        q.next = p;
        return q;
    }

    // 递归实现
    public ListNode reverseList3(ListNode node) {
        return reverseListIterative(node, null, null);
    }

    public static ListNode justReverse(ListNode start, ListNode stop) {
        if (start == stop)
            return start;
        justReverse(start.next, stop).next = start;
        return start;
    }

    // Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then; // start节点不需要改变，只需不断修改其next节点
            then = start.next; // then节点需要不断移动！
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

    //Reverse Nodes in k-Group

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        if (tmp == null)
            return null;
        // 链表长度小于k,则返回head
        for (int i = 0; i < k - 1; ++i) {
            tmp = tmp.next;
            if (tmp == null)
                return head;
        }
        ListNode tail = tmp; // head到tmp节点，一共有k个节点。
        tmp = tmp.next;
        //反转head后面的k个节点
        reverseListIterative(head, null, tail.next);
        head.next = reverseKGroup(tmp, k);
        return tail;
    }

    // 反转head到tailNext之间的链表部分,包括head,不包括tail[head,tailNext)区间的链表！！！
    // 反转整个链表，需要把tailNext置为null即可！！！
    private ListNode reverseListIterative(ListNode head, ListNode newHead, ListNode tailNext) {
        if (head == tailNext)
            return newHead;
        ListNode next = head.next;
        head.next = newHead; // 连接
        return reverseListIterative(next, head, tailNext);
    }

}
