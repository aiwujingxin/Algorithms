package LeetCode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/2 23:58
 */
public class LeetCode122_greedy {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/discuss/948090/Java-very-simple-solution-with-explaination

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
