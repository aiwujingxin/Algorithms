package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 18:41
 */
public class LCR112 {

    int[][] memo;

    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y);
            max = Math.max(max, len);
        }
        memo[i][j] = max;
        return max;
    }
}
