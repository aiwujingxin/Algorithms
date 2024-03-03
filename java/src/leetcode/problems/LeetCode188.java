package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/28 23:24
 */
public class LeetCode188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] f = new int[n + 1][k + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j][1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + prices[i - 1]);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return f[n][k][0];
    }
}
