package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 00:07
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int[] last = intervals[0];
        List<int[]> list = new ArrayList<>();
        list.add(last);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] > last[1]) {
                list.add(cur);
                last = cur;
            } else {
                int[] newInt = new int[2];
                newInt[0] = last[0];
                newInt[1] = Math.max(cur[1], last[1]);
                list.remove(list.size() - 1);
                list.add(newInt);
                last = newInt;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
