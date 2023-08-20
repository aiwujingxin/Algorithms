package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-12 1:52 上午
 */
public class LeetCode121 {

    //https://www.youtube.com/watch?v=helrhutBYnk&t=59s
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
