package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 22:09
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }
}
