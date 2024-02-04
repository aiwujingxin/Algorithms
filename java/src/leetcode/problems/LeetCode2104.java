package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 12:00
 * @see leetcode.problems.LeetCode907
 */
public class LeetCode2104 {
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] leftMax = new int[n];

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && nums[stack1.peek()] <= nums[i]) {
                stack1.pop();
            }
            leftMax[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] >= nums[i]) {
                stack2.pop();
            }
            leftMin[i] = stack2.isEmpty() ? -1 : stack2.peek();
            stack2.push(i);
        }
        int[] rightMin = new int[n];
        int[] rightMax = new int[n];
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack1.isEmpty() && nums[stack1.peek()] < nums[i]) {
                stack1.pop();
            }
            rightMax[i] = stack1.isEmpty() ? n : stack1.peek();
            stack1.push(i);

            while (!stack2.isEmpty() && nums[stack2.peek()] > nums[i]) {
                stack2.pop();
            }
            rightMin[i] = stack2.isEmpty() ? n : stack2.peek();
            stack2.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            long leftMaxCount = i - leftMax[i];
            long rightMaxCount = rightMax[i] - i;
            long max = nums[i] * (leftMaxCount * rightMaxCount);
            long leftMinCount = i - leftMin[i];
            long rightMinCount = rightMin[i] - i;
            long min = nums[i] * (leftMinCount * rightMinCount);
            res += max - min;
        }
        return res;
    }
}
