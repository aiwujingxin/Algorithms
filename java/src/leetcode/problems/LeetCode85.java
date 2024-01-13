package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/8 16:55
 */
public class LeetCode85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] heights = new int[n];
        int res = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(heights));
        }
        return res;
    }

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
