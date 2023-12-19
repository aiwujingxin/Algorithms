package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 21:44
 * @description 两次单调栈
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == Integer.MIN_VALUE) {
                res[i] = -1;
            }
        }
        return res;
    }
}
