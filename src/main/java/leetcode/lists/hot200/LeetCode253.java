package leetcode.lists.hot200;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:10
 */
public class LeetCode253 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        queue.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (queue.peek()[1] <= intervals[i][0]) {
                queue.poll();
            }
            queue.add(intervals[i]);
        }
        return queue.size();
    }
}
