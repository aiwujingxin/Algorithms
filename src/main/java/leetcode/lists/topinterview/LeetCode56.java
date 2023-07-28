package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 02:22
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            if (last[1] >= intervals[i][0]) {
                int[] newInt = new int[2];
                newInt[0] = last[0];
                newInt[1] = Math.max(last[1], intervals[i][1]);

                list.remove(list.size() - 1);
                list.add(newInt);
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);

        }
        return res;

    }
}
