package leetcode.problems;

import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/6 13:44
 */
public class LeetCode2866 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] pre = new long[n];
        long[] sufix = new long[n];
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }
            int index = stack.isEmpty() ? -1 : stack.peek();
            long t = stack.isEmpty() ? 0 : pre[stack.peek()];
            pre[i] = t + (long) (i - index) * maxHeights.get(i);
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && maxHeights.get(stack.peek()) > maxHeights.get(i)) {
                stack.pop();
            }
            int index = stack.isEmpty() ? n : stack.peek();
            long t = stack.isEmpty() ? 0 : sufix[stack.peek()];
            sufix[i] += t + (long) (index - i) * maxHeights.get(i);
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(pre[i] + sufix[i] - maxHeights.get(i), res);
        }
        return res;
    }
}
