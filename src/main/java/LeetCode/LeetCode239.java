package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2022-01-24 12:05 AM
 */
public class LeetCode239 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[]{};
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        //init
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}
