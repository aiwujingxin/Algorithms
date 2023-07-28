package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/5 00:32
 */
public class LeetCode1696_sd {

    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        queue.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            while (i - queue.peek()[1] > k) {
                queue.poll();
            }
            res = queue.peek()[0] + nums[i];
            queue.offer(new int[]{res, i});
        }
        return res;
    }
}
