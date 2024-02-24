package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 19:55
 */
public class LeetCode334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek();
            stack.push(i);
        }
        int rmax = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < rmax && left[i] < i) {
                return true;
            }
            rmax = Math.max(rmax, nums[i]);
        }
        return false;
    }

    public boolean increasingTriplet_LIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int left = 0;
            int right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len >= 3;
    }
}
