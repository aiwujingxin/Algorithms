package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 18:43
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        Stack<Integer> stack1 = new Stack<>();
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack1.empty() && heights[i] <= heights[stack1.peek()]) {
                stack1.pop();
            }
            left[i] = stack1.empty() ? 0 : stack1.peek() + 1;
            stack1.push(i);
        }
        int[] right = new int[n];
        Stack<Integer> stack2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.empty() && heights[i] <= heights[stack2.peek()]) {
                stack2.pop();
            }
            right[i] = stack2.empty() ? n - 1 : stack2.peek() - 1;
            stack2.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        }
        return res;

    }
}
