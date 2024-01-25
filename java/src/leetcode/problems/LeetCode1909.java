package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/25 13:24
 */
public class LeetCode1909 {

    public boolean canBeIncreasing(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        return desc(nums) >= nums.length - 1 || asc(nums) >= nums.length - 1;
    }

    public int desc(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        return stack.size();
    }

    public int asc(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        return stack.size();
    }
}
