package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 16:26
 * @see LeetCode516
 */
public class LeetCode1312 {

    Integer[][] memo;

    public int minInsertions(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        memo = new Integer[n][n];
        return dfs(chars, 0, n - 1);
    }

    private int dfs(char[] chars, int l, int r) {
        if (l == r) {
            return 0;
        }
        if (l + 1 == r) {
            memo[l][r] = chars[l] == chars[r] ? 0 : 1;
            return chars[l] == chars[r] ? 0 : 1;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        if (chars[l] == chars[r]) {
            return memo[l][r] = dfs(chars, l + 1, r - 1);
        }
        return memo[l][r] = Math.min(dfs(chars, l + 1, r), dfs(chars, l, r - 1)) + 1;
    }

    public int minInsertions_dp(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }

    public int minInsertions_reverse(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        // LCS(s, reverse(s))
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
