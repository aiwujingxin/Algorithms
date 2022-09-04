package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:20
 */
public class LeetCode188_dp_3d_v2 {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1007170/Java-Recursive-greater-Memoization-greater-3D-Bottom-Up-greater-2D-Bottom-Up

    public int maxProfit(int k, int[] prices) {
        int[][][] profit = new int[prices.length + 1][2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int j = 1; j <= k; j++) {
                    profit[i][state][j] = (state == 0) ?
                            Math.max(profit[i + 1][1][j] - prices[i], profit[i + 1][state][j]) :
                            Math.max(profit[i + 1][0][j - 1] + prices[i], profit[i + 1][state][j]);
                }
            }
        }

        return profit[0][0][k];
    }
}
