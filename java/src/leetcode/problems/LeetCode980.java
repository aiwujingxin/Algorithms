package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/18/25 00:04
 */
public class LeetCode980 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int uniquePathsIII(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int si = 0, sj = 0, n = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    n++;
                } else if (grid[i][j] == 1) {
                    n++;
                    si = i;
                    sj = j;
                }
            }
        }
        return backtrack(grid, si, sj, n);
    }

    public int backtrack(int[][] grid, int i, int j, int n) {
        if (grid[i][j] == 2) {
            return n == 0 ? 1 : 0;
        }
        int r = grid.length, c = grid[0].length;
        int t = grid[i][j];
        grid[i][j] = -1;
        int res = 0;
        for (int[] dir : dirs) {
            int nx = i + dir[0], ny = j + dir[1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] != -1) {
                res += backtrack(grid, nx, ny, n - 1);
            }
        }
        grid[i][j] = t;
        return res;
    }
}
