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

    public int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        int max = 0;
        for (int k = l; k <= r; k++) { // 闭区间
            max = Math.max(max, (l - 1 >= 0 ? nums[l - 1] : 1) * nums[k] * (r + 1 < nums.length ? nums[r + 1] : 1) +
                    dfs(nums, l, k - 1) +
                    dfs(nums, k + 1, r));
        }
        memo[l][r] = max;
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
        for (int len = 2; len < n; len++) {
            System.out.println("规模 " + len + " 时:");
            for (int l = 1; l < n - len + 1; l++) {
                int r = l + len - 1;
                System.out.println("子问题 [" + l + " ~ " + r + "]");
                // k 是要戳的气球，左闭右开区间  [l....k] [k+1....r]
                for (int k = l; k < r; k++) {
                    System.out.println("划分点" + "k=" + k + " dp[" + l + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + r + "]" + " +" + " p" + "[" + (l - 1) + "]" + "*" + "p[" + k + "]" + "*" + "p[" + r + "]");
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k + 1][r] + p[l - 1] * p[k] * p[r]);
                }
                System.out.println("dp[" + l + "]" + "[" + r + "] " + dp[l][r]);
            }
            System.out.println();
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[1][n - 1];
    }
}
