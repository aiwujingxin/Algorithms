package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/15 12:54
 */
public class LeetCode862 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<long[]> queue = new PriorityQueue<>(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o2[1], o1[1]);
            }
            return Long.compare(o1[0], o2[0]);
        }));
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && presum[i] - queue.peek()[0] >= k) {
                long[] node = queue.poll();
                res = Math.min(i - node[1], res);
            }

            queue.add(new long[]{presum[i], i});

        }
        return res == Integer.MAX_VALUE ? -1 : (int) res;
    }
}
