import java.util.HashMap;

public class MinimumWindowSubstring {

//https://leetcode.com/problems/minimum-window-substring/description/

    public static void main(String[] args) {

        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        HashMap<Character, Integer> tMap = new HashMap<>(); // t中字符出现次数的map
        HashMap<Character, Integer> windowMap = new HashMap<>(); // 区间中字符的出现次数Map！
        for (char ch : t.toCharArray()) {
            if (tMap.containsKey(ch)) {
                tMap.put(ch, tMap.get(ch) + 1);
            } else {
                tMap.put(ch, 1);
            }
        }
        int matchCount = 0;
        int lo = 0;
        int hi = 0;
        int minLen = -1;
        int minLeft = 0;
        for (; hi < s.length(); ++hi) {
            char ch = s.charAt(hi);
            if (windowMap.containsKey(ch)) {
                windowMap.put(ch, windowMap.get(ch) + 1);
            } else {
                windowMap.put(ch, 1);
            }
            if (tMap.containsKey(ch) && windowMap.get(ch) <= tMap.get(ch))
                matchCount++;

            if (matchCount == t.length()) {
                if (hi - lo + 1 < minLen) {
                    minLeft = lo;
                    minLen = hi - lo + 1;
                }
            }
            while (matchCount == t.length()) {
                //移动lo
                char tmp = s.charAt(lo);
                ++lo;
                windowMap.put(tmp, windowMap.get(tmp) - 1);
                if (tMap.containsKey(tmp) && windowMap.get(tmp) < tMap.get(tmp)) {
                    --matchCount;
                } else if (hi - lo + 1 < minLen) {
                    minLeft = lo;
                    minLen = hi - lo + 1;
                }
            }
        }
        return minLen == -1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

}
