package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/19 18:27
 */
public class LeetCode892 {

    public int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    sum += 2;
                }
                for (int[] dir : dirs) {
                    int tempx = i + dir[0];
                    int tempy = j + dir[1];
                    if (tempx < 0 || tempx >= m || tempy < 0 || tempy >= n) {
                        sum += grid[i][j];
                    } else {
                        if (grid[i][j] > grid[tempx][tempy]) {
                            sum += grid[i][j] - grid[tempx][tempy];
                        }
                    }
                }
            }
        }
        return sum;
    }
}
