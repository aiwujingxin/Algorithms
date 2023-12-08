package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 22:37
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // init值有讲究
        int hold1 = Integer.MIN_VALUE;
        int sold1 = 0;
        int hold2 = Integer.MIN_VALUE;
        int sold2 = 0;
        for (int price : prices) {
            int hold1temp = hold1;
            int sold1temp = sold1;
            int hold2temp = hold2;
            hold1 = Math.max(-price, hold1temp);
            sold1 = Math.max(hold1temp + price, sold1temp);
            hold2 = Math.max(sold1temp - price, hold2temp);
            sold2 = Math.max(hold2temp + price, sold2);
        }
        return Math.max(sold1, sold2);
    }
}
