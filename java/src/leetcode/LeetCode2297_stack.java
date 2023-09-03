package leetcode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 11:40
 */
public class LeetCode2297_stack {
    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = 0;
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);
        Stack<Integer> stack2 = new Stack<>();
        stack2.push(0);
        for (int i = 1; i < n; i++) {
            int num = nums[i], cost = costs[i];
            long currMin = Long.MAX_VALUE;
            while (!stack1.isEmpty() && nums[stack1.peek()] <= num) {
                currMin = Math.min(currMin, dp[stack1.pop()] + cost);
            }
            stack1.push(i);
            while (!stack2.isEmpty() && nums[stack2.peek()] > num) {
                currMin = Math.min(currMin, dp[stack2.pop()] + cost);
            }
            stack2.push(i);
            dp[i] = currMin;
        }
        return dp[n - 1];
    }
}
