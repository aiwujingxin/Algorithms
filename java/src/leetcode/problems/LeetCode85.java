package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 03:41
 */
public class LeetCode85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[j] == '1') {
                    heights[j] += 1;
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

        Stack<Integer> stack1 = new Stack<>();
        int[] left = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!stack1.empty() && heights[i] <= heights[stack1.peek()]) {
                stack1.pop();
            }
            left[i] = stack1.empty() ? 0 : stack1.peek() + 1;
            stack1.push(i);
        }
        Stack<Integer> stack2 = new Stack<>();
        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack2.empty() && heights[i] <= heights[stack2.peek()]) {
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

    public int maximalRectangle_dp(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == '1') {
                dp[0][col] = 1;
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = dp[row - 1][col] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] == 0) {
                    continue;
                }
                int tm = dp[i][j];
                for (int left = j; left >= 0; left--) {

                    if (dp[i][left] == 0) {
                        break;
                    }
                    if (dp[i][left] < tm) {
                        tm = dp[i][left];
                    }
                    res = Math.max(res, (j - left + 1) * tm);

                }
            }
        }
        return res;
    }
}
