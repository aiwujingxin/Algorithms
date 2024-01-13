package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 21:32
 */
public class LeetCode581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int left = n;
        int right = -1;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        if (right == left) {
            return 0;
        }
        return right - left > 0 ? right - left + 1 : 0;
    }
}
