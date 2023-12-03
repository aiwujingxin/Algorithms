package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:23
 * @see LeetCode452
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int n = intervals.length;
        int end = intervals[0][1];
        int ans = 1;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                ans++;
            }
        }
        return n - ans;
    }
}
