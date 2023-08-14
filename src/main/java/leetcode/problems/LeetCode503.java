package leetcode.problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-12 5:21 PM
 */
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;

    }

    public int[] nextGreaterElementsV2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = (nums.length << 1) - 1; i >= 0; i--) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            if (i <= nums.length - 1) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(num);
        }
        return res;
    }

}
