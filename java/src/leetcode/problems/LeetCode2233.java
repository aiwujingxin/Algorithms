package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 16:45
 */
public class LeetCode2233 {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000_000_007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (k > 0) {
            k--;
            pq.offer(pq.poll() + 1);
        }
        long ans = 1;
        while (!pq.isEmpty()) {
            ans = (ans * pq.poll()) % mod;
        }
        return (int) ans;
    }
}
