import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class S11TOS20 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    // S11 Brute Force
    public int maxArea(int[] height) {
        int x = 0;
        int y = 1;
        int len = height.length;
        if (len < 2) return 0;
        int ans = 0;
        for (; x < len - 1; ++x) {
            for (; y < len; ++y) {
                ans = Math.max(ans, (y - x) * Math.min(height[x], height[y]));
            }
        }
        return ans;
    }

    // S11 双指针法与证明：https://leetcode.com/problems/container-with-most-water/discuss/6099/yet-another-way-to-see-what-happens-in-the-on-algorithm/174248


    // S15 ThreeSum

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    public List<List<Integer>> threeSum(int[] nums, int lo, int hi, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        int len = hi;
        int tmpSum = 0;
        int j, k;

        for (int i = lo; i < len - 2; ++i) {
            if (i == lo || nums[i - 1] != nums[i]) {
                j = i + 1;
                k = len - 1;
                while (j < k) {
                    tmpSum = nums[i] + nums[j] + nums[k];
                    if (tmpSum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j + 1] == nums[j]) ++j;
                        while (j < k && nums[k - 1] == nums[k]) --k;
                        ++j; // 不要忘记这里自加1
                        --k;
                    } else if (tmpSum < target) {
                        ++j;
                    } else {
                        --k;
                    }
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        int tmpSum = 0;
        int j, k;

        for (int i = 0; i < len - 2; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                j = i + 1;
                k = len - 1;
                while (j < k) {
                    tmpSum = nums[i] + nums[j] + nums[k];
                    if (tmpSum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j + 1] == nums[j]) ++j;
                        while (j < k && nums[k - 1] == nums[k]) --k;
                        ++j; // 不要忘记这里自加1
                        --k;
                    } else if (tmpSum < target) {
                        ++j;
                    } else {
                        --k;
                    }
                }
            }
        }
        return ans;
    }
    // S16. 3 sum closest

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int delta = Integer.MAX_VALUE;
        int ans = 0;
        int tmpSum = 0;
        int j, k;

        for (int i = 0; i < len - 2; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                j = i + 1;
                k = len - 1;
                while (j < k) {
                    tmpSum = nums[i] + nums[j] + nums[k];
                    if (tmpSum == target) return target;
                    if (tmpSum > target) {
                        if (tmpSum - target < delta) {
                            ans = tmpSum;
                            delta = tmpSum - target;
                        }
                        --k;
                    } else {
                        if (target - tmpSum < delta) {
                            ans = tmpSum;
                            delta = target - tmpSum;
                        }
                        ++j;

                    }
                }

            }
        }
        return ans;
    }


    // S17  回溯法
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new LinkedList<>();
        if (digits.length() == 0)
            return ans;// 一定记得排除掉异常输入，如输入为空字符串等情况
        letterComb("", digits, ans, map);
        return ans;
    }

    public static void letterComb(String prefix, String digits, List<String> ans, HashMap<Character, String> map) {
        if (digits.length() == 0) {
            ans.add(prefix);
            return;
        }
        char ch = digits.charAt(0);
        for (char c : map.get(ch).toCharArray()) {
            letterComb(prefix + c, digits.substring(1), ans, map);
        }
    }

    // S18 four sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        List<List<Integer>> threeSumResult = new LinkedList<>();
        for (int i = 0; i < len - 3; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                threeSumResult = threeSum(nums, i + 1, nums.length, target - nums[i]);
                for (List<Integer> item : threeSumResult) {
                    ans.add(Arrays.asList(nums[i], item.get(0), item.get(1), item.get(2)));
                }

            }
        }
        return ans;
    }

    // S19 Remove Nth Node From End of List


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //S19
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode back = head;
        ListNode front = head;
        for (int i = 0; i < n; ++i) {
            front = front.next;
        }
        if (front == null) {
            return head.next; // 特殊情况判断：当需要删除链表中的第一个节点时
        } else {
            while (front.next != null) {
                front = front.next;
                back = back.next;
            }
            ListNode deleteNode = back.next;
            back.next = deleteNode.next;
            return head;
        }
    }




}
