package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:34
 */
public class LeetCode239_queue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // 单调递减
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - queue.getFirst() >= k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
