import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S1ToS10 {

    public static void main(String[] args) {
        System.out.println(-11 % 10);
    }

    //s3:Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        HashSet<Character> windowSet = new HashSet<>();
        int i = 0, j = 0;
        int n = s.length();
        int ans = 0;
        while (i < n && j < n) {

            if (windowSet.contains(s.charAt(j))) {
                windowSet.remove(s.charAt(i));
                ++i;
            } else {
                windowSet.add(s.charAt(j));
                ans = Math.max(j - i + 1, ans);
                ++j;
            }

        }
        return ans;
    }


    // S4
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//
//    }
    // S5 Dynamic Programming
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    // S7 Reverse Integer


    public int reverse(int x) {
        int result = 0;
        int tmp = x;
        int tmpResult = 0;
        if (x >= 0) {
            while (tmp != 0) {
                tmpResult = result; // save last result!!!
                result = result * 10;
                if (result / 10 != tmpResult) return 0; // determine if result overflows!!
                result = result + tmp % 10;
                tmp = tmp / 10;
            }
        } else {
            tmp = 0 - x;
            while (tmp != 0) {
                tmpResult = result;
                result = result * 10;
                if (result / 10 != tmpResult) return 0;
                result = result - tmp % 10;
                tmp = tmp / 10;
            }
        }
        return result;
    }


    // S8
    // 整数溢出情况，标准解法！！！
    public static int myAtoi(String str) {
        int len = str.length();
        int i = 0;
        int flag = 1;
        int tmp = 0, result = 0;
        int tmpResult = 0;
        for (i = 0; i < len; ++i) {
            if (str.charAt(i) != ' ')
                break;
        }
        if (i == len) return 0;
        if (str.charAt(i) == '-') {
            flag = -1;
            ++i;
        } else if (str.charAt(i) == '+') {
            ++i;
        } else if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) return 0;


        if (flag == 1) {
            for (; i < str.length(); ++i) {
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) break;
                // 当为正数时，判断与Integer.MAX_VALUE/10的大小关系
                if (tmp > Integer.MAX_VALUE / 10 || (tmp == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                result = tmp * 10 + str.charAt(i) - '0';
                tmp = result;
            }
        } else {
            for (; i < str.length(); ++i) {
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) break;
                //当为负数时，判断与Integer.MIN_VALUE/10的大小关系！
                if (tmp < Integer.MIN_VALUE / 10 || (tmp == Integer.MIN_VALUE / 10 && ('0' - str.charAt(i)) < Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;
                result = tmp * 10 + '0' - str.charAt(i);
                tmp = result;
            }
        }
        return result;
    }


    public boolean isMatch(String s, String p) {


        return  false;
    }

}
