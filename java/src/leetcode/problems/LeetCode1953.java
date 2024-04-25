package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 00:41
 */
public class LeetCode1953 {

    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        long totalCount = 0;
        for (int milestone : milestones) {
            pq.add((long) milestone);
            totalCount = totalCount + milestone;
        }
        long max = pq.peek();
        totalCount = totalCount - max;
        long ans = 0;
        while (!pq.isEmpty()) {
            long cur = pq.poll();
            if (pq.isEmpty()) {
                if (totalCount >= max) {
                    return ans + cur;
                } else {
                    return ans + 1;
                }
            }
            long num2 = pq.poll();
            ans = ans + num2 * 2;
            cur = cur - num2;
            if (cur > 0) {
                pq.add(cur);
            }
        }
        return ans;
    }
}
