package basic.template.Acwing;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/7 12:45
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
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
