package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:34
 * @description 单调递减队列
 */
public class LeetCode239_dq {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i - dq.getFirst() >= k) {
                dq.pollFirst();
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
