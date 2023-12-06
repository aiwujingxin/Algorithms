package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 12:57
 */
public class LeetCode495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int time : timeSeries) {
            if (max >= time) {
                res -= (max - time + 1);
            }
            res += duration;
            max = time + duration - 1;
        }
        return res;
    }
}
