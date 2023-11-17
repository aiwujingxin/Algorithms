package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 18:08
 */
public class LeetCode329 {


    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        int res = 1;
        for (int i = 0; i < dirs.length; i++) {
            int xn = row + dirs[i][0];
            int yn = col + dirs[i][1];
            if (xn < 0 || xn >= matrix.length || yn < 0 || yn >= matrix[0].length || matrix[xn][yn] <= matrix[row][col]) {
                continue;
            }
            res = Math.max(res, dfs(matrix, xn, yn) + 1);
        }
        memo[row][col] = res;
        return res;
    }
}
