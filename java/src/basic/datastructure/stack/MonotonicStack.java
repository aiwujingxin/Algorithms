package basic.datastructure.stack;

import leetcode.problems.LeetCode739;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 21:59
 * @see LeetCode739 每日温度
 */
public class MonotonicStack {

    public int[] nextGreaterElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = -1; // There's no greater element
        }

        return result;
    }
}
