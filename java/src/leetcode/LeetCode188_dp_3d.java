package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:00
 */
public class LeetCode188_dp_3d {


    public int maxProfit(int count, int[] prices) {
        int[][][] dp = new int[prices.length + 1][count + 1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < count + 1; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int k = 1; k <= count; k++) {
                int val = prices[i - 1];
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + val);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - val);
            }
        }
        return dp[prices.length][count][0];
    }
}
