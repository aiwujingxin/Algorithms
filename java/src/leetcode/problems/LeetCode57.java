package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 20:26
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int m = findL(intervals, newInterval);
        int n = findR(intervals, newInterval);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(intervals[i]);
        }
        if (m <= n) {
            list.add(new int[]{Math.min(intervals[m][0], newInterval[0]), Math.max(intervals[n][1], newInterval[1])});
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

    private int findL(int[][] intervals, int[] newInterval) {
        int l = 0;
        int r = intervals.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (intervals[mid][1] < newInterval[0]) l = mid + 1;
            else r = mid;
        }
        if (intervals[l][1] < newInterval[0]) {
            return l + 1;
        }
        return l;
    }

    private int findR(int[][] intervals, int[] newInterval) {
        int l = 0;
        int r = intervals.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (intervals[mid][0] > newInterval[1]) r = mid - 1;
            else l = mid;
        }
        if (intervals[l][0] > newInterval[1]) {
            return l - 1;
        }
        return l;
    }
}
