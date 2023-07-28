package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 20:47
 */
public class LeetCode56 {


    //[[1,4],[2,3]]
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {

            int[] last = list.get(list.size() - 1);
            if (last[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                int[] newInterval = new int[2];
                newInterval[0] = last[0];
                newInterval[1] = Math.max(last[1], intervals[i][1]);
                list.remove(list.size() - 1);
                list.add(newInterval);
            }
        }

        int[][] res = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
