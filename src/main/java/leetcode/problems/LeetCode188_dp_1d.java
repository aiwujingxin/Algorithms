package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 10:49
 */
public class LeetCode188_dp_1d {

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) { // if k >= n/2, then you can make maximum number of transactions
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            return profit;
        }
        int[] buy = new int[k + 1], sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }
}
