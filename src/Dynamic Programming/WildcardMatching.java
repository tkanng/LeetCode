

/*
自顶向下——备忘录法
 */
public class WildcardMatching {
    enum Result {
        TRUE, FALSE
    }

    private Result[][] memo;

    public boolean dp(int i, int j, String text, String pattern) {

        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }

        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else if (i == text.length()) {
            ans = true;
            for (int t = j; t < pattern.length(); ++t) {
                if (pattern.charAt(t) != '*') {
                    ans = false;
                    break;
                }
            }
        } else {
            if (pattern.charAt(j) == '*') {
                ans = dp(i + 1, j, text, pattern) || dp(i, j + 1, text, pattern);
            } else {
                ans = (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        memo = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        System.out.println(test.isMatch("qq", "aqq*"));
    }

}

/* 自低向上——填表法：
1. 首先填表格里面边界值。
2. 然后，按照递归关系，按次序得到表格中的其他值。
在本题中，我们先填dp[text.length()][j](0<= j <= pattern.length())与dp[i][pattern.length()](0<=i<=text.length())
*/

class BottomUp {

    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;


        int lastNotStarIdx = -1; // 初始值置为-1！！
        for (int t = pattern.length() - 1; t >= 0; --t) {
            if (pattern.charAt(t) != '*') {
                lastNotStarIdx = t;
                break;
            }
        }
        for (int x = 0; x < pattern.length(); ++x) {
            dp[text.length()][x] = x > lastNotStarIdx;
        }

        for (int i = text.length() - 1; i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (pattern.charAt(j) == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else {
                    dp[i][j] = (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }

}

class Recursive {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        // 这里需要注意的是，对于text为空时，需要对pattern进行判断
        if (text.isEmpty()) {
            for (char ch : pattern.toCharArray()) {
                if (ch != '*')
                    return false;
            }
            return true;
        }

        if (pattern.charAt(0) == '*') {
            // 两种情况：1. 利用'*'进行匹配 2. 不利用'*'进行匹配
            return isMatch(text.substring(1), pattern) || isMatch(text, pattern.substring(1));
        }
        boolean first_match = (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '?');
        return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
}




