package leetcode.hot100;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 14:45
 */
public class LeetCode739_reverse {

    public int[] dailyTemperatures(int[] temperatures) {
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
