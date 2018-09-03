/**
 * 寻找字符串中最长回文字符子串
 *
 */


public class LongestPalindromicSubstring {
    // 判断一个i到j的字符串是否为回文字符串：
    // 如果字符串长度j-i + 1 >2, 条件:P(i+1, j-1)&&s[i]==s[j]
    // 如果j-i +1 <=2, 即长度为1或2.长度为1，必为回文;长度为2,条件: s[i] == s[j]
    // j-i + 1<=2 时，条件即为 s[i] == s[j]
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // (i+1, j-1) ===> (i, j)，所以i=n-1,逐渐减小,j=i,逐渐增大。
            // 循环的方向，画出一个坐标图！
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring t = new LongestPalindromicSubstring();
        System.out.println(t.longestPalindrome("cbbd"));
    }

}
