package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:52
 */
public class LeetCode85 {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int res = 0;
        int[] heights = new int[n];
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, new LeetCode84().largestRectangleArea(heights));
        }
        return res;
    }
}
