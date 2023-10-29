package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:24
 * @see LeetCode188
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        int[][][] profit = new int[prices.length + 1][2][2 + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int j = 1; j <= 2; j++) {
                    profit[i][state][j] = (state == 0) ?
                            Math.max(profit[i + 1][1][j] - prices[i], profit[i + 1][state][j]) :
                            Math.max(profit[i + 1][0][j - 1] + prices[i], profit[i + 1][state][j]);
                }
            }
        }

        return profit[0][0][2];
    }
}
