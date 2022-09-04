/*
 * @Author: aiwujingxin@gmail.com
 * @Date: 2022-06-08 19:41:54
 * @LastEditTime: 2022-06-23 01:25:12
 * @LastEditors: aiwujingxin@gmail.com
 */
package leetCode.problems;

import java.util.Stack;

public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) stack.pop();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) right[i] = N - 1;
            else right[i] = stack.peek() - 1;
            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            int area = heights[i] * (right[i] - left[i] + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
