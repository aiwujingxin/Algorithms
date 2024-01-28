package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/28 14:32
 */
public class LeetCode883 {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int[] xMax = new int[n];
        int[] yMax = new int[n];

        int xy = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, grid[i][j]);
                if (grid[i][j] > 0) {
                    xy++;
                }
            }
            xMax[i] = max;
        }
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, grid[i][j]);
            }
            yMax[j] = max;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += xMax[i] + yMax[i];
        }
        return sum + xy;
    }
}
