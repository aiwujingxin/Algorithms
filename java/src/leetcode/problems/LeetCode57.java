package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:30
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int m = findStartIndex(intervals, newInterval[0]);
        int n = findEndIndex(intervals, newInterval[1]);

        for (int i = 0; i < m; i++) {
            list.add(intervals[i]);
        }
        if (m <= n) {
            int start = Math.min(intervals[m][0], newInterval[0]);
            int end = Math.max(intervals[n][1], newInterval[1]);
            list.add(new int[]{start, end});
        } else {
            list.add(newInterval);
        }

        for (int i = n + 1; i < intervals.length; ++i) {
            list.add(intervals[i]);
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int findStartIndex(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (intervals[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (intervals[left][1] < target) {
            return left + 1;
        }
        return left;
    }

    private int findEndIndex(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (intervals[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (intervals[left][0] > target) {
            return left - 1;
        }
        return left;
    }
}
