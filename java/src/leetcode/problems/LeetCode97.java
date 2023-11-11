package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 15:57
 */
public class LeetCode97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= n && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int index = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s3.charAt(index) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(index) == s2.charAt(j - 1));

            }
        }
        return dp[m][n];
    }
}
