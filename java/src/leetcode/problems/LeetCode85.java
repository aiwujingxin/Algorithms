package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:52
 */
public class LeetCode85 {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') h[j]++;
                else h[j] = 0;
            }
            max = Math.max(max, new LeetCode84().largestRectangleArea(h));
        }
        return max;
    }
}
