package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:21
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] > last[1]) {
                list.add(cur);
            } else {
                list.remove(list.size() - 1);
                int[] ints = new int[2];
                ints[0] = Math.min(cur[0], last[0]);
                ints[1] = Math.max(cur[1], last[1]);
                list.add(ints);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[][] merge_acwing(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<int[]> list = new ArrayList<>();
        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (ed < interval[0]) {
                if (st != Integer.MIN_VALUE) {
                    list.add(new int[]{st, ed});
                }
                st = interval[0];
                ed = interval[1];
            } else {
                ed = Math.max(ed, interval[1]);
            }
        }
        if (st != Integer.MIN_VALUE) {
            list.add(new int[]{st, ed});
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
