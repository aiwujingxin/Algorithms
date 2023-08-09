package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/20 02:10
 */
public class LeetCode239_Q_TEL {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
