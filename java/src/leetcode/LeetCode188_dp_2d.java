package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:20
 */
public class LeetCode188_dp_2d {

    public int maxProfit(int k, int[] prices) {
        int[][] profit = new int[2][k + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int j = 1; j <= k; j++) {
                    profit[state][j] = (state == 0) ?
                            Math.max(profit[1][j] - prices[i], profit[state][j]) :
                            Math.max(profit[0][j - 1] + prices[i], profit[state][j]);
                }
            }
        }
        return profit[0][k];
    }
}
