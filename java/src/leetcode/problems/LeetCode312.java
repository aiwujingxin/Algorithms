package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:47
 * @link <a href="https://cloud.tencent.com/developer/article/1880884">dp</a>
 * @description 矩阵链乘法 《算法导论 p210》
 */
public class LeetCode312 {

    Integer[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        points[0] = points[n + 1] = 1;
        memo = new Integer[n + 2][n + 2];
        return dfs(points, 0, n + 1);
    }

    public int dfs(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = i + 1; k < j; k++) {
            max = Math.max(max, nums[i] * nums[k] * nums[j] + dfs(nums, i, k) + dfs(nums, k, j));
        }
        memo[i][j] = max;
        return max;
    }

    public int maxCoins_dp(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 3; len <= n + 2; len++) {
            for (int l = 0; l + len - 1 <= n + 1; l++) {
                int r = l + len - 1;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k][r] + arr[l] * arr[k] * arr[r]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
