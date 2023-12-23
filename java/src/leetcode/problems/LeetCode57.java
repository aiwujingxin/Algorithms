package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 20:26
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int m = findStart(intervals, newInterval[0]);
        int n = flndEnd(intervals, newInterval[1]);
        for (int i = 0; i < m - 1; i++) {
            list.add(intervals[i]);
        }
        if (m <= n) {
            int a = Math.min(intervals[m][0], newInterval[0]);
            int b = Math.max(intervals[n][1], newInterval[1]);
            list.add(new int[]{a, b});
        } else {
            list.add(newInterval);
        }
        for (int i = n + 1; i < intervals.length; i++) {
            list.add(intervals[i]);
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int findStart(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
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

    private int flndEnd(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
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
