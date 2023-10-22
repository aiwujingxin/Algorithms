package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/22 20:57
 */
public class LeetCode456 {

    //https://www.youtube.com/watch?v=jZsATHFXyNw

    public boolean find132pattern(int[] nums) {
        int numk = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < numk) {
                return true;
            }
            while (!stack.empty() && nums[i] > stack.peek()) {
                numk = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
