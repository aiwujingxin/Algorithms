package leetcode.problems;

import java.util.Stack;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 00:10
 */
public class LeetCode1673 {

    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[k];
        int count = n - k;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && count > 0) {
                stack.pop();
                count--;
            }
            stack.push(nums[i]);
        }
        while (count > 0) {
            stack.pop();
            count--;
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
