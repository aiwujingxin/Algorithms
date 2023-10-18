package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 22:58
 */
public class LeetCode436 {

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[]{};
        }
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int index = find(startIntervals, end);
            ans[i] = index;
        }
        return ans;
    }

    private int find(int[][] startIntervals, int end) {

        int left = 0;
        int right = startIntervals.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (startIntervals[mid][0] < end) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (startIntervals[left][0] < end) {
            return -1;
        }
        return startIntervals[left][1];
    }
}
