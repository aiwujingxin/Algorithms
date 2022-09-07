package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:48
 */
public class LeetCode221_greedy {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            // 最小值
            min = Math.min(min, prices[i - 1]);
            if (prices[i] > min) {
                max = Math.max((prices[i] - min), max);
            }
        }
        return max;
    }
}
