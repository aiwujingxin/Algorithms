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

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        list.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] last = list.get(list.size() - 1);
            if (interval[0] > last[1]) {
                list.add(interval);
            } else {
                int[] t = new int[2];
                t[0] = Math.min(last[0], interval[0]);
                t[1] = Math.max(last[1], interval[1]);
                list.remove(list.size() - 1);
                list.add(t);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
