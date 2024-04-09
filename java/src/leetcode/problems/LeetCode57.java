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
        int m = leftBound(intervals, newInterval[0]);
        int n = rightBound(intervals, newInterval[1]);
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

    private int leftBound(int[][] intervals, int target) {
        int l = 0;
        int r = intervals.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (intervals[mid][1] < target) l = mid + 1;
            else r = mid;
        }
        if (intervals[l][1] < target) {
            return l + 1;
        }
        return l;
    }

    private int rightBound(int[][] intervals, int target) {
        int l = 0;
        int r = intervals.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (intervals[mid][0] > target) r = mid - 1;
            else l = mid;
        }
        if (intervals[l][0] > target) {
            return l - 1;
        }
        return l;
    }
}
