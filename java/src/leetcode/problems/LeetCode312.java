package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:47
 * @link <a href="https://cloud.tencent.com/developer/article/1880884">dp</a>
 * @description 反过来想 长气球
 */
public class LeetCode312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        points[0] = points[n + 1] = 1;
        int[][] memo = new int[n + 2][n + 2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(points, 0, n + 1, memo);
    }

    public int dfs(int[] points, int i, int j, int[][] memo) {
        if (i >= j - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        for (int k = i + 1; k < j; k++) {
            int sum = points[i] * points[k] * points[j] + dfs(points, i, k, memo) + dfs(points, k, j, memo);
            memo[i][j] = Math.max(memo[i][j], sum);
        }
        return memo[i][j];
    }

    int maxCoins_dp(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
