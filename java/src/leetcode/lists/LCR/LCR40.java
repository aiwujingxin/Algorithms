package leetcode.lists.LCR;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 21:33
 */
public class LCR40 {

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length()];
        int maxArea = 0;
        for (String row : matrix) {
            //遍历每一列，更新高度
            for (int col = 0; col < row.length(); col++) {
                if (row.charAt(col) == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int res = Integer.MIN_VALUE;

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

        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
        }
        return res;
    }
}
