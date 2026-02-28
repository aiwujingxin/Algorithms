package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 00:08
 */
public class LeetCode1504 {

    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int totalRectangles = 0;
        int[] height = new int[n];
        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {
                height[j] += row[j];
            }
            totalRectangles += countRowRectangles(height);
        }
        return totalRectangles;
    }

    // 时间复杂度：O(N)
    private int countRowRectangles(int[] heights) {
        int n = heights.length;
        int sum = 0;
        int[] dp = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                dp[i] = heights[i] * (i + 1);
            } else {
                int preIndex = stack.peek();
                dp[i] = dp[preIndex] + heights[i] * (i - preIndex);
            }
            stack.push(i);
            sum += dp[i];
        }
        return sum;
    }

    // 时间复杂度：O(N^2)
    public int countRowRectanglesForce(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int i = 0; i < n; i++) { //  i 是矩形的【左边界】
            int min_h = heights[i];
            for (int j = i; j < n; j++) {  // j 是矩形的【右边界】，从左往右找
                min_h = Math.min(min_h, heights[j]);
                ans += min_h;
            }
        }
        return ans;
    }
}
