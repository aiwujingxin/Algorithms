package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 11:05
 */
public class LeetCode188_dfs {

    public static void main(String[] args) {
        System.out.println(new LeetCode188_dfs().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1007170/Java-Recursive-greater-Memoization-greater-3D-Bottom-Up-greater-2D-Bottom-Up

    public int maxProfit(int k, int[] prices) {
        return maxProfit(0, 0, k, prices);
    }

    private int maxProfit(int i, int state, int k, int[] prices) {
        if (i >= prices.length || k == 0) {
            return 0;
        }

        return state == 0 ?
                // 无-> 买入   保持无
                Math.max(maxProfit(i + 1, 1, k, prices) - prices[i], maxProfit(i + 1, state, k, prices)) :
                // 持有-> 卖出  ， 保持持有
                Math.max(maxProfit(i + 1, 0, k - 1, prices) + prices[i], maxProfit(i + 1, state, k, prices));
    }
}
