package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-01-24 12:05 AM
 */
public class LeetCode239_deque {

    //https://leetcode.com/problems/sliding-window-maximum/discuss/2651803/Java-O(n)-solution-using-deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.getFirst() == i - k) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
