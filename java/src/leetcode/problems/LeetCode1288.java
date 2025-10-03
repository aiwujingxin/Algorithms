package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 8/6/25 10:51
 */
public class LeetCode1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int count = 0;
        int prevEnd = 0;
        for (int[] interval : intervals) {
            int end = interval[1];
            if (end > prevEnd) {
                count++;
                prevEnd = end;
            }
        }
        return count;
    }
}
