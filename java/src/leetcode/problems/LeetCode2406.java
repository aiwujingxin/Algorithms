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
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] p : intervals) {
            if (!pq.isEmpty() && pq.peek() < p[0]) {
                int last = pq.poll();
                pq.add(Math.max(last, p[1]));
            } else {
                pq.add(p[1]);
            }
        }
        return pq.size();
    }
}
