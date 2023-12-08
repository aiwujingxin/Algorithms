package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/28 23:24
 */
public class LeetCode188 {

    public int maxProfit(int K, int[] prices) {
        int[] hold = new int[K + 1];
        int[] sold = new int[K + 1];
        Arrays.fill(hold, Integer.MIN_VALUE / 2);
        Arrays.fill(sold, Integer.MIN_VALUE / 2);
        hold[0] = 0;
        sold[0] = 0;
        for (int price : prices) {
            int[] holdOld = hold.clone();
            int[] soldOld = sold.clone();
            for (int k = 1; k <= K; k++) {
                hold[k] = Math.max(soldOld[k - 1] - price, holdOld[k]);
                sold[k] = Math.max(holdOld[k] + price, soldOld[k]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int j = 0; j <= K; j++) {
            result = Math.max(result, sold[j]);
        }
        return result;
    }
}
