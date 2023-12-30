package leetcode.problems;

import java.util.Arrays;
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
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            int index = leftBound(dp, num);
            dp[index] = Math.min(dp[index], num);
            res = Math.max(res, index);
        }
        return res >= 3;
    }

    public int leftBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) {
            return left + 1;
        }
        return left;
    }
}
