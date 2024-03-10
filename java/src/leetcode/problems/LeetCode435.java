package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:23
 * @description 找到最大不重叠区间的个数
 */
public class LeetCode435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - solve(intervals);
    }

    public int solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int end = intervals[0][1];
        int cnt = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                cnt++;
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
