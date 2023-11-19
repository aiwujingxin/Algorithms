package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 14:49
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures_reverse(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        //        7 5 6 7 8 9 10
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
