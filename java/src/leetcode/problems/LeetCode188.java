package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:06
 * @link <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1007170/Java-Recursive-greater-Memoization-greater-3D-Bottom-Up-greater-2D-Bottom-Up">...</a>
 */
public class LeetCode188 {

    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][2][k + 1];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        //0, buy 1, sell
        return dfs(0, 0, k, prices, memo);
    }

    private int dfs(int i, int state, int k, int[] prices, int[][][] memo) {
        if (i >= prices.length || k == 0) {
            return 0;
        }
        if (memo[i][state][k] != -1) {
            return memo[i][state][k];
        }
        return memo[i][state][k] = (state == 0) ?
                // If we are currently only allowed to 'buy', We can either buy the current stock or move onto the next stock
                Math.max(dfs(i + 1, 1, k, prices, memo) - prices[i], dfs(i + 1, state, k, prices, memo)) :
                //If we are currently only allowed to 'sell', We can either sell at the current stock or move onto the next stock
                Math.max(dfs(i + 1, 0, k - 1, prices, memo) + prices[i], dfs(i + 1, state, k, prices, memo));
    }

    public int maxProfit_dp(int k, int[] prices) {
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
