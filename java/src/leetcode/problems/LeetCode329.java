package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:13
 */
public class LeetCode329 {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            res = Math.max(res, 1 + dfs(matrix, x, y, m, n));
        }
        memo[i][j] = res;
        return res;
    }
}
