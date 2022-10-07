package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 16:23
 */
public class LeetCode239_Q_TEL {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // stores values

        for (int i = 0; i < n; ++i) {
            int start = i - k;
            if (start >= 0) {
                maxPQ.remove(nums[start]); // remove the out-of-bound value
            }
            maxPQ.offer(nums[i]);
            if (maxPQ.size() == k) {
                result[i - k + 1] = maxPQ.peek();
            }
        }
        return result;
    }
}
