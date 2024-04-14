package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 22:47
 * @link <a href="https://cloud.tencent.com/developer/article/1880884">dp</a>
 */
public class LeetCode312 {

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            arr[i] = nums[i - 1];
        }
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int r = 2; r < n; r++) {
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
                }
            }
        }
        return dp[1][n - 1];
    }
}
