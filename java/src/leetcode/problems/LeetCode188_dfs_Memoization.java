package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:06
 */
public class LeetCode188_dfs_Memoization {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1007170/Java-Recursive-greater-Memoization-greater-3D-Bottom-Up-greater-2D-Bottom-Up

    public int maxProfit(int k, int[] prices) {
        int[][][] memo = new int[prices.length][2][k + 1];

        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }

        return maxProfit(0, 0, k, prices, memo);
    }

    private int maxProfit(int i, int state, int k, int[] prices, int[][][] memo) {
        if (i >= prices.length || k == 0) {
            return 0;
        }
        if (memo[i][state][k] != -1) {
            return memo[i][state][k];
        }
        return memo[i][state][k] = (state == 0) ?
                Math.max(maxProfit(i + 1, 1, k, prices, memo) - prices[i], maxProfit(i + 1, state, k, prices, memo)) :
                Math.max(maxProfit(i + 1, 0, k - 1, prices, memo) + prices[i], maxProfit(i + 1, state, k, prices, memo));
    }

}
