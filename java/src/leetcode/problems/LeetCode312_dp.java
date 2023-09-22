package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 23:24
 */
public class LeetCode312_dp {

    //https://www.youtube.com/watch?v=Ci39lcoLbyw
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int t = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    t = Math.max(t, arr[i - 1] * arr[k] * arr[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
                dp[i][j] = t;
            }
        }
        return dp[1][n];
    }
}
