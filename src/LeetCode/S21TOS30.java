import javax.swing.*;
import java.util.*;

public class S21TOS30 {
    public static void main(String[] args) {

        System.out.println(-19%20);
    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode tmp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if (l1 == null) {
            tmp.next = l2;
        } else {
            tmp.next = l1;
        }
        return head;
    }

    // 递归解法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    // S22 不会     使用回溯法！
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();


        return ans;
    }


    // S23
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        };
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(1, cmp);
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                q.add(lists[i]);
            }
        }
        ListNode head = null;
        if (q.isEmpty()) {
            return null;
        } else {
            head = q.poll();
            if (head.next != null) q.add(head.next);
        }
        ListNode tmp = head;
        if (q.isEmpty())
            return head;
        while (q.size() != 1) {
            tmp.next = q.poll();
            if (tmp.next != null && tmp.next.next != null) {
                q.add(tmp.next.next);
            }
            tmp = tmp.next;
        }
        tmp.next = q.poll();
        return head;
    }


    // S24

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode tmp = new ListNode(head.next.val);
        head.next = swapPairs(head.next.next);
        tmp.next = head;
        return tmp;
    }

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
        tmp = tmp.next; // 将tmp指向下一个可能需要反转区间的起始节点。
        //反转head后面的k个节点
        justReverse(head, tail);
        head.next = reverseKGroup(tmp, k);
        return tail;
    }

    public static ListNode justReverse(ListNode start, ListNode stop) {
        if (start == stop)
            return start;
        justReverse(start.next, stop).next = start;
        return start;
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int nextPlaceLocation = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                nums[nextPlaceLocation] = nums[i];
                ++nextPlaceLocation;
            }
        }
        return nextPlaceLocation;
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int nextPlaceLoc = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[nextPlaceLoc] = nums[i];
                ++nextPlaceLoc;
            }
        }
        return nextPlaceLoc;
    }

    //S28
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int len = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i <= len - needle.length(); ++i) {
            if (haystack.substring(i, i + nLen).equals(needle))
                return i;
        }
        return -1;
    }




}
