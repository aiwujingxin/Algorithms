package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/20 20:24
 * @description 从两侧向内缩小问题规模
 */
public class LeetCode516 {

    private char[] chars;
    private int[][] memo;

    public int longestPalindromeSubseq(String S) {
        int n = chars.length;
        this.chars = S.toCharArray();
        this.memo = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0; // 空串
        }
        if (i == j) {
            return 1; // 只有一个字母
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (chars[i] == chars[j]) {
            return memo[i][j] = dfs(i + 1, j - 1) + 2; // 都选
        }
        return memo[i][j] = Math.max(dfs(i + 1, j), dfs(i, j - 1)); // 枚举哪个不选
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
