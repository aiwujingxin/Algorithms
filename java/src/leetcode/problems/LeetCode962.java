package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 19:01
 */
public class LeetCode962 {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] minArr = new int[n];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            minArr[i] = min;
        }
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = leftBound(minArr, nums[i]);
            if (minArr[index] <= nums[i]) {
                res = Math.max(res, i - index);
            }
        }
        return res;
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int maxWidthRamp_stack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                max = Math.max(max, i - stack.pop());
            }
        }
        return max;
    }
}
