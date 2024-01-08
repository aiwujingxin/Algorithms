package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/23 23:48
 */
public class LeetCode1508 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] presum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < presum.length; i++) {
            for (int j = i + 1; j < presum.length; j++) {
                pq.add(presum[j] - presum[i]);
            }
        }
        for (int i = 0; i < left - 1; i++) {
            pq.poll();
        }
        long sum = 0;
        for (int i = 0; i < right - left + 1; i++) {
            sum = (sum + pq.poll()) % 1000000007;
        }
        return (int) sum % 1000000007;
    }
}
