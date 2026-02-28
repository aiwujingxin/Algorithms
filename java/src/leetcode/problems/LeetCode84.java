package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:38
 */
public class LeetCode84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }

    // 横向切分计算
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            // 1. 哨兵优化：首尾加0，简化栈空判断和残留元素处理
            int[] arr = new int[n + 2];
            System.arraycopy(heights, 0, arr, 1, n);
            Deque<Integer> stack = new ArrayDeque<>();
            int maxArea = 0;
            for (int i = 0; i < arr.length; i++) {
                // 2. 遇到更小高度，触发结算
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    int h = arr[stack.pop()];       // 当前高度
                    int w = i - stack.peek() - 1;   // 宽度 = 右边界 - 左边界 - 1
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.push(i);
            }
            return maxArea;
        }
    }
}
