import java.util.Stack;

public class AddTwoNum {
    // https://leetcode.com/problems/add-two-numbers/description/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int currentSum = 0;
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode ptr = head;
        carry = (l1.val + l2.val) / 10;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            currentSum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            ptr.next = new ListNode(currentSum % 10);
            carry = currentSum / 10;
            ptr = ptr.next;
            // 一定注意边界条件！
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }
        return head;
    }

    // add Two Num 逆序计算！
    // https://leetcode.com/problems/add-two-numbers-ii/description/
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        int carry = 0;
        ListNode head = null;
        ListNode tmp = null;
        while (!s1.empty() || !s2.empty()) {
            sum = carry;
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            tmp = new ListNode(sum % 10);
            tmp.next = head;
            head = tmp;
            carry = sum / 10;
        }
        if (carry == 1) {
            tmp = new ListNode(1);
            tmp.next = head;
            head = tmp;
        }
        return head;
    }

}
