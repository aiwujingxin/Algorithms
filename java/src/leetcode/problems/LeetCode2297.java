package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 11:16
 */
public class LeetCode2297 {

    public long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack1.isEmpty() && nums[stack1.peek()] <= num) {
                graph[i].add(stack1.pop());
            }
            while (!stack2.isEmpty() && nums[stack2.peek()] > num) {
                graph[i].add(stack2.pop());
            }
            stack1.push(i);
            stack2.push(i);
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int cost = costs[i];
            for (int next : graph[i]) {
                dp[i] = Math.min(dp[i], dp[next] + cost);
            }
        }
        return dp[n - 1];
    }
}
