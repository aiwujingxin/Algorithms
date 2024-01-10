package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 21:44
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
        }
        return res;
    }
}
