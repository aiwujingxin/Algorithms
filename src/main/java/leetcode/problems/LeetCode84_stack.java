package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/5 18:21
 */
public class LeetCode84_stack {

    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/2662000/Java-Optimal-Solution-Time-O(n)-and-Space-O(n)
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                int rHeight = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                maxArea = Math.max(width * rHeight, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
