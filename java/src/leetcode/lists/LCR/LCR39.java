package leetcode.lists.LCR;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 21:20
 */
public class LCR39 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack1 = new Stack<>();
        int[] left = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack1.empty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            left[i] = stack1.empty() ? 0 : stack1.peek() + 1;
            stack1.push(i);
        }
        Stack<Integer> stack2 = new Stack<>();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack2.empty() && heights[stack2.peek()] >= heights[i]) {
                stack2.pop();
            }
            right[i] = stack2.empty() ? heights.length - 1 : stack2.peek() - 1;
            stack2.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        }
        return res;
    }
}
