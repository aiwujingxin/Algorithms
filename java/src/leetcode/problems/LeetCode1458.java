package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 21:45
 */
public class LeetCode1458 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int v = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + v, v), Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}
