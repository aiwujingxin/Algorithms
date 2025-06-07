package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 20:24
 */
public class LeetCode516 {

    private char[] chars;
    private Integer[][] memo;

    public int longestPalindromeSubseq(String S) {
        int n = chars.length;
        this.chars = S.toCharArray();
        this.memo = new Integer[n][n];
        return dfs(0, n - 1);
    }

    private int dfs(int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        if (chars[l] == chars[r]) {
            return memo[l][r] = dfs(l + 1, r - 1) + 2; // 都选
        }
        return memo[l][r] = Math.max(dfs(l + 1, r), dfs(l, r - 1)); // 枚举哪个不选
    }

    public int longestPalindromeSubseq_dp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
