package knowledge.algorithms.twopoint.impl.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 单调队列滑动窗口模板 (Monotonic Queue Sliding Window)
 * <p>
 * 核心思想：
 * 使用双端队列（Deque）存储元素的索引，并保持队列中元素值的单调性（递减或递增）。
 * 这样可以在 O(1) 的时间内获取滑动窗口内的最大值或最小值。
 * <p>
 * 适用场景：
 * - 滑动窗口最大值 (LeetCode 239)
 * - 绝对差不超过限制的最长连续子数组 (LeetCode 1438)
 */
public class MonotonicQueueSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 双端队列，存储的是元素的索引，保持队列内元素对应的值单调递减
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 1. 移除不在当前窗口内的元素（队头）
            // 窗口范围是 [i - k + 1, i]，如果队头索引 < i - k + 1，则过期
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 2. 保持队列单调递减性，移除队尾比当前元素小的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 3. 将当前元素索引入队
            deque.offerLast(i);

            // 4. 当窗口形成后（即 i >= k - 1），记录答案（队头元素即为当前窗口最大值）
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
