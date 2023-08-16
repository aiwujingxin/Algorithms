package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:39
 */
public class LeetCode121_v2 {

    public int maxProfitV2(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

}
