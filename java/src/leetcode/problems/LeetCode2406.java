package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 00:12
 * @see LeetCode253
 */
public class LeetCode2406 {

    // 1. 按左端点从小到大排序
    // 2. 从前往后处理每一个区间
    //    判断能否将其放到现有的某个组中：当前区间的左端点<=Max_r
    //       1. 如果不存在这样的组，则开新组，然后再将其放进去
    //       2. 如果存在这样的组，，然后再将其放进去，更新当前组的 Max_r
    public int minGroups(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}
