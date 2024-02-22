package leetcode.lists.lcr;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/14 02:14
 * @see knowledge.datastructure.queue.MonotonicQueue
 */
public class LCR183 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(new int[]{nums[i], i});
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
