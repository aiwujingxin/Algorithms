package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 3/3/25 23:04
 */
public class LeetCode1547 {

    public int minCost(int n, int[] cuts) {
        int m = cuts.length + 2;
        Arrays.sort(cuts);
        int[] arr = new int[m];
        System.arraycopy(cuts, 0, arr, 1, m - 2);
        arr[m - 1] = n;
        int[][] dp = new int[m][m];
        for (int i = m - 3; i >= 0; i--) {
            for (int j = i + 2; j < m; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    res = Math.min(res, dp[i][k] + dp[k][j]);
                }
                dp[i][j] = res + arr[j] - arr[i];
            }
        }
        return dp[0][m - 1];
    }
}
