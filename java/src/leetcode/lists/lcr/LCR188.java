package leetcode.lists.lcr;

/**
 * @author jingxinwu
 * @date 2021-12-04 3:12 下午
 */
public class LCR188 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 不持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[dp.length - 1][0];
    }


    // 我们需要找出给定数组中两个数字之间的最大差值

    public int maxProfit_greedy(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }

    // 滑动窗口
    // [7,1,5,3,6,4]
    int maxProfitV2(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int left = 0, right = 0, maxP = 0;
        while (right < len) {
            if ((prices[right] - prices[left]) < 0) {
                left = right;
                right++;
                continue;
            }
            maxP = Math.max(maxP, prices[right] - prices[left]);
            right++;
        }
        return maxP;
    }

    // 暴力
    public int maxProfitV3(int[] prices) {
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
