package leetcode.problems;

public class LeetCode85_v2 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (char[] chars : matrix) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (chars[col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, new LeetCode84().largestRectangleArea(heights));
        }
        return maxArea;
    }
}
