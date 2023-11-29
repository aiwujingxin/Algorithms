package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 17:51
 */
public class LeetCode436 {

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[]{};
        }
        int n = intervals.length;
        int[][] _intervals = new int[intervals.length][];
        for (int i = 0; i < n; i++) {
            _intervals[i] = new int[]{intervals[i][0], intervals[i][1], i};
        }
        Arrays.sort(_intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = find(_intervals, intervals[i][1]);
            if (index == -1 || i == index) {
                res[i] = -1;
            }
            res[i] = index;
        }
        return res;
    }

    private int find(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (intervals[left][0] < target) {
            return -1;
        }
        return intervals[left][2];
    }
}
