package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 5/26/26 01:28
 */
public class LeetCode3835 {

    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        long ans = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            int c = nums[right];
            while (!min.isEmpty() && c <= nums[min.peekFirst()]) {
                min.pollFirst();
            }
            min.addFirst(right);
            while (!max.isEmpty() && c >= nums[max.peekFirst()]) {
                max.pollFirst();
            }
            max.addFirst(right);
            while ((long) (nums[max.peekLast()] - nums[min.peekLast()]) * (right - left + 1) > k) {
                left++;
                if (min.peekLast() < left) {
                    min.pollLast();
                }
                if (max.peekLast() < left) {
                    max.pollLast();
                }
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
