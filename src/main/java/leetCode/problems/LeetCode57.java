package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2021-06-24 10:59 下午
 */
public class LeetCode57 {

    //https://leetcode-cn.com/problems/insert-interval/solution/shou-hua-tu-jie-57-cha-ru-qu-jian-fen-cheng-3ge-ji/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int l = intervals.length;
        int i = 0;
        // 当前遍历的是蓝左边的，不重叠的区间
        while (i < l && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // 当前遍历是有重叠的区间
        while (i < l && intervals[i][0] <= newInterval[1]) {
            //左端取较小者，更新给蓝区间的左端
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            //右端取较大者，更新给蓝区间的右端
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // 循环结束后，区间为合并后的区间，推入res
        result.add(newInterval);
        // 在蓝右边，没重叠的区间
        while (i < l) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] insertV2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int m = findStartIndex(intervals, newInterval[0]);
        int n = findEndIndex(intervals, newInterval[1]);
        for (int i = 0; i < m; ++i) {
            result.add(intervals[i]);
        }
        if (m <= n) {
            int start = Math.min(intervals[m][0], newInterval[0]);
            int end = Math.max(intervals[n][1], newInterval[1]);
            result.add(new int[]{start, end});
        } else {
            result.add(newInterval);
        }
        for (int i = n + 1; i < intervals.length; ++i) {
            result.add(intervals[i]);
        }
        return result.toArray(new int[result.size()][]);
    }

    private int findStartIndex(int[][] intervals, int target) {
        int s = 0;
        int e = intervals.length - 1;
        while (s <= e) {
            int m = (s + e) >> 1;
            int[] median = intervals[m];
            if (median[1] == target) {
                return m;
            }
            if (median[1] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return s;
    }

    private int findEndIndex(int[][] intervals, int target) {
        int s = 0;
        int e = intervals.length - 1;
        while (s <= e) {
            int m = (s + e) >> 1;
            int[] median = intervals[m];
            if (median[0] == target) {
                return m;
            }
            if (median[0] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return e;
    }
}
