package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 16:26
 */
public class LeetCode1312 {

    public int minInsertions(String s) {
        return s.length() - new LeetCode516().longestPalindromeSubseq(s);
    }

    public int minInsertions_dp1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] chars = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }

    public int minInsertions_lcs(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
