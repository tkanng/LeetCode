
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minIdx(new int[]{-1, 1, 2, 9}));
    }

    public static int minIdx(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums[0] < nums[nums.length - 1])
            return 0;
        if (nums[nums.length - 1] < nums[nums.length - 2])
            return nums.length - 1;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        int ans = 0;
        while (lo < hi) {
            mid = (hi + lo) / 2;
            if (mid == lo) {
                if (nums[lo] < nums[hi]) ans = lo;
                else ans = hi;
                return ans;
            }
            if (nums[lo] >= nums[mid]) {
                hi = mid;
            } else if (nums[mid] >= nums[hi]) {
                lo = mid;
            }
        }
        return ans;
    }


    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int LLen = 0;
        LLen = L.length * L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> seen = new HashMap<String, Integer>();

        for (int i = 0; i < L.length; ++i) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        int required = map.size();
        int formed = 0;
        int wordLen = L[0].length();
        int lo = 0, hi = LLen - 1;
        String tmpStr = "";
        while (hi < S.length()) {
            formed = 0;
            for (int i = lo; i + wordLen <= hi + 1; ) {
                tmpStr = S.substring(i, i + wordLen);
                if (seen.containsKey(tmpStr)) {
                    seen.put(tmpStr, seen.get(tmpStr) + 1);
                } else {
                    seen.put(tmpStr, 1);
                }
                if (!map.containsKey(tmpStr)) {
                    break;
                } else {
                    if (map.get(tmpStr) < seen.get(tmpStr)) {
                        break;
                    } else if (map.get(tmpStr) == seen.get(tmpStr)) {
                        formed++;
                        if (formed == required) {
                            ans.add(lo);
                        }
                    }

                }
                i = i + wordLen;
            }
            ++lo;
            ++hi;
        }
        return ans;
    }

    class MyQueue {

        /**
         * Initialize your data structure here.
         */
        Stack<Integer> inStack, outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }


    class MyStack {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> Q1, Q2;

        public MyStack() {
            this.Q1 = new LinkedList<>();
            this.Q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (Q2.isEmpty()) {
                Q1.add(x);
            } else {
                Q2.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int tmp = 0;
            if (!Q1.isEmpty()) {
                while (!Q1.isEmpty()) {
                    tmp = Q1.poll();
                    if (Q1.isEmpty()) {
                        return tmp;
                    }
                    Q2.add(tmp);
                }

            } else {
                while (!Q2.isEmpty()) {
                    tmp = Q2.poll();
                    if (Q2.isEmpty()) {
                        return tmp;
                    }
                    Q1.add(tmp);
                }
            }
            return tmp;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int tmp = 0;
            if (!Q1.isEmpty()) {
                while (!Q1.isEmpty()) {
                    tmp = Q1.poll();
                    Q2.add(tmp);
                }

            } else {
                while (!Q2.isEmpty()) {
                    tmp = Q2.poll();
                    Q1.add(tmp);
                }
            }
            return tmp;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return Q1.isEmpty() && Q2.isEmpty();
        }
    }


}