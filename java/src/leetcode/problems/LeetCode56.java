package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:21
 */
public class LeetCode56 {

    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] cur : nums) {
            if (res.isEmpty() || cur[0] > res.get(res.size() - 1)[1]) {
                res.add(cur);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], cur[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
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
