package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/5 18:22
 */
public class LeetCode84_stack_v2 {


    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/2648075/Java-oror-Simple-O(n)-Solution-oror-Core-Stack-problem
    public int largestRectangleArea(int[] heights) {
        int[] nsl = nextSmallerToLeft(heights);
        int[] nsr = nextSmallerToRight(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (nsr[i] - nsl[i] - 1));
        }
        return maxArea;
    }

    public int[] nextSmallerToLeft(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] nextSmallerToRight(int[] heights) {
        int[] res = new int[heights.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }
        return res;
    }
}
