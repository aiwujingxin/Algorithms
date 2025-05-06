package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:44
 */
public class LeetCode32 {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if (i > 0 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longestValidParentheses_stack(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - (stack.isEmpty() ? -1 : stack.peek()));
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
