package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/11 21:59
 */
public class LeetCode1000 {

    private int[][] memo;
    private int[] s;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) {
            return -1;
        }
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }
        this.k = k;
        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MAX_VALUE;
        for (int l = i; l < j; l += k - 1) {
            ans = Math.min(ans, dfs(i, l) + dfs(l + 1, j));
        }
        if ((j - i) % (k - 1) == 0) {
            ans += s[j + 1] - s[i];
        }
        return memo[i][j] = ans;
    }

    public int mergeStones_dp(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                // 判断区间 [i..j] 是否可以最终合并为一堆
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][n - 1];
    }
}
