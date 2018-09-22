/*
Very Similar to Longest Common Subsequence Problem.

Let, s1 & s2 be the two strings with 1 based indexes.
Now assume, dp[i][j] = minimumDeleteSum( s1[0,i], s2[0,j])

Base case:
When either of the strings is empty, then whole of the other string has to be deleted.
for e.g. if s1 = "", s2 = "abc", then only way we could match these strings by deleting characters is by dropping 'a','b','c' of s2 to make it empty like s1.

Thus, whenever one of them is empty(i.e. i==0 or j==0) then answer is sum of ASCII code of the characters of the other string.

Hence the 1st rule: dp[i][j] =
sum_ascii(s2) -> if i==0
sum_ascii(s1) -> if j==0
Non-Base case
Of the two strings, if both of their last characters match then certainly the answer comes from skipping those characters.
i.e. Answer("zca","bza") = Answer("zc","bz")
Hence the 2nd rule: dp[i][j] =
dp[i-1][j-1] -> if s1[i]==s2[j]
Finally, if the last characters are different then its one of the three situations:
drop s1's last character (ASCII(s1's last) + dp[i-1][j])
drop s2's last character (ASCII(s2's last) + dp[i][j-1])
drop both last characters (ASCII(s1's last) + ASCII(s2's last) + dp[i-1[[j-1])
Hence the 3rd rule: dp[i][j] =

Min((ASCII(s1's last) + dp[i-1][j]),(ASCII(s2's last) + dp[i][j-1]),(ASCII(s1's last) + ASCII(s2's last) + dp[i-1[[j-1]))
Combining these 3 rules gives us an elegant solution.
 */
public class MinimumASCIIDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    int a = 0;
                    for (int z = 1; z <= Math.max(j, i); z++) {
                        a += (i == 0 ? s2.charAt(z - 1) : s1.charAt(z - 1));
                    }
                    dp[i][j] = a;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], s1.charAt(i - 1) + s2.charAt(j - 1) + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

