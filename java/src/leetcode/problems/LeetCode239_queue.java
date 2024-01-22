package leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:34
 */
public class LeetCode239_queue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekFirst()]) {
                deque.pollFirst();
            }
            deque.addFirst(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekLast()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekFirst()]) {
                deque.pollFirst();
            }
            deque.addFirst(i);
            while (i - deque.peekLast() + 1 > k) {
                deque.pollLast();
            }
            ans[i - k + 1] = nums[deque.peekLast()];
        }
        return ans;
    }
}
