package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-25 2:47 PM
 */
public class LeetCode516 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
