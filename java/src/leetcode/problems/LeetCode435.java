package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:23
 * @description 找到最大不重叠区间的个数
 * @see LeetCode452
 * @see LeetCode646
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int n = intervals.length;
        int end = intervals[0][1];
        int cnt = 1;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                cnt++;
            }
        }
        return n - cnt;
    }
}
