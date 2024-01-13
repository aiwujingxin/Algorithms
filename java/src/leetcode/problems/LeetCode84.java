package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 15:06
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] leftMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            leftMin[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int[] rightMin = new int[n];
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            rightMin[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * ((rightMin[i] - 1) - (leftMin[i] + 1) + 1));
        }
        return res;
    }
}
