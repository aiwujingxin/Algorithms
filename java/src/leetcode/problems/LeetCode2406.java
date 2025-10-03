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

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }
}
