package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:51
 */
public class LeetCode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        for (int i = 0; i < k; i++) {
            queue.add(new int[]{i, nums[i]});
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek()[1];

        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{i, nums[i]});
            while (!queue.isEmpty() && queue.peek()[0] < i - k + 1) {
                queue.poll();
            }
        }
        return res;
    }
}
