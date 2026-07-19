package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 21:34
 * @description 单调队列 <单调><固定长度><窗口>
 */
public class LeetCode239_dq {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && i - dq.getFirst() >= k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) dq.pollLast();
            dq.addLast(i);
            if (i - k + 1 >= 0) res[i - k + 1] = nums[dq.getFirst()];
        }
        return res;
    }
}
