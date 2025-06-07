package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:47
 * @link <a href="https://cloud.tencent.com/developer/article/1880884">dp</a>
 */
public class LeetCode312 {

    public static void main(String[] args) {
        System.out.println(new LeetCode312().maxCoins_dp2(new int[]{3, 1, 5, 8}));
    }

    private Integer[][] memo;
    private int[] p;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        p = new int[n + 2];
        memo = new Integer[n + 2][n + 2];
        p[0] = 1;
        p[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = nums[i];
        }
        return dfs(0, n + 1); // 从开区间 (0, n+1) 开始
    }

    private int dfs(int l, int r) {
        if (r - l <= 1) {
            return 0; // 开区间 (l, r) 内没有气球了
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        int max = 0;
        for (int k = l + 1; k < r; k++) { // k 是最后一个戳的气球
            max = Math.max(max, dfs(l, k) + dfs(k, r) + p[l] * p[k] * p[r]);
        }
        return memo[l][r] = max;
    }

    // 斜着遍历
    public int maxCoins_dp1(int[] nums) {
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

    //从下往上遍历
    public int maxCoins_dp2(int[] nums) {
        int n = nums.length;
        int[] p = new int[n + 2];
        p[0] = p[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = nums[i];
        }
        // dp[i][j]：戳破开区间 (i, j)（不包含 i 和 j）之间的气球，所能获得的最大硬币数。
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                System.out.println("计算区间 dp[" + i + "][" + j + "]，尝试所有 k ∈ (" + i + ", " + j + ")");
                //遍历k: 尝试戳破每一个 k（i < k < j）位置的气球
                //cost: [i+1, k-1] 的部分已经戳完了，[k+1, j-1] 的部分也戳完了，最后戳 k，获得的硬币数是 p[i] * p[k] * p[j]
                for (int k = i + 1; k < j; k++) {
                    System.out.println("  选择 k = " + k + "：dp[" + i + "][" + k + "](" + dp[i][k] + ") + " + "dp[" + k + "][" + j + "](" + dp[k][j] + ") + " + p[i] + "*" + p[k] + "*" + p[j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + p[i] * p[k] * p[j]);
                }
            }
        }
        System.out.println("最终 DP 表:");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        return dp[0][n + 1];
    }
}
