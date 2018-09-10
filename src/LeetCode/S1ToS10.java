import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class S1ToS10 {

    public static void main(String[] args) {
//        int rollMeOver = Integer.MAX_VALUE + 1;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(rollMeOver);
//        System.out.println(Integer.MAX_VALUE + 1 > Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MIN_VALUE - 1);
        System.out.println(myAtoi("2147483648"));
        System.out.println(Integer.MIN_VALUE);
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

    //S3
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

    // S4 不会
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
                if (i == j)
                    dp[i][j] = true;
                else if (i == j - 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1]);
                }
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    // S6 不会


    // S7 reverse integer.  检查整数溢出情况！

    public static int reverse(int x) {
        int result = 0;
        int dig = 0;
        int temp = 0;
        while (x != 0) {
            dig = x % 10;
            temp = dig + result * 10; // 正数溢出，会变为负数;负数溢出，会变为正数
            if ((temp - dig) / 10 != result) {
                return 0;
            }
            result = temp;
            x = x / 10;
        }
        return result;
    }

    // S8: String to Integer (atoi)

    public static int myAtoi(String str) {
        int len = str.length();
        int i = 0;
        int flag = 1;
        long tmp = 0l, result = 0l;
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
                result = tmp * 10 + (str.charAt(i) - '0');

                if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                tmp = result;
            }
        } else {
            for (; i < str.length(); ++i) {
                if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) break;
                result = tmp * 10 - (str.charAt(i) - '0');
                if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                tmp = result;
            }
        }
        return (int) result;
    }


    // S9
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int len = s.length();
        int low = 0;
        int high = s.length() - 1;
        if (len % 2 == 0) {
            //even
            for (int i = 0; i < len / 2; ++i) {
                if (s.charAt(low) != s.charAt(high))
                    return false;
                ++low;
                --high;
            }
            return true;
        } else {
            //odd
            for (int i = 0; i < len / 2; ++i) {
                if (s.charAt(low) != s.charAt(high))
                    return false;
                ++low;
                --high;
            }
            return true;
        }
    }









}
