package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:47
 * @link <a href="https://cloud.tencent.com/developer/article/1880884">dp</a>
 */
public class LeetCode312 {

    Integer[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return dfs(nums, 0, n - 1);
    }

    public int dfs(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, (i - 1 >= 0 ? nums[i - 1] : 1) * nums[k] * (j + 1 < nums.length ? nums[j + 1] : 1) + dfs(nums, i, k - 1) + dfs(nums, k + 1, j));
        }
        memo[i][j] = max;
        return max;
    }

    public int maxCoins_dp(int[] nums) {
        int[] p = new int[nums.length + 2];
        p[0] = p[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            p[i] = nums[i - 1];
        }
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int r = 2; r < n; r++) {
            System.out.println("规模 " + r + " 时");
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r - 1;
                System.out.println("子问题 dp[" + i + "]" + "[" + j + "]");
                // k 是要戳的气球
                for (int k = i; k < j; k++) {
                    System.out.println("划分点" + "k=" + k + " dp[" + i + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + j + "]" + " +" + " p" + "[" + (i - 1) + "]" + "*" + "p[" + k + "]" + "*" + "p[" + j + "]");
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j]);
                }
                System.out.println("dp[" + i + "]" + "[" + j + "] " + dp[i][j]);
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        // 左闭右开区间
        return dp[1][n - 1];
    }
}
