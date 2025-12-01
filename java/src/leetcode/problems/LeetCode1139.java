package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2025/11/26 16:15
 */
public class LeetCode1139 {
    int[][] s;

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        s = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = Math.min(m - 1 - i, n - 1 - j);
                while (len >= 0) {
                    if (sumRegion(i, j, i, j + len) == len + 1 &&
                            sumRegion(i, j, i + len, j) == len + 1 &&
                            sumRegion(i, j + len, i + len, j + len) == len + 1 &&
                            sumRegion(i + len, j, i + len, j + len) == len + 1) {
                        ans = Math.max((len + 1) * (len + 1), ans);
                        break;
                    }
                    len--;
                }
            }
        }
        return ans;
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return s[r2 + 1][c2 + 1] - s[r1][c2 + 1] - s[r2 + 1][c1] + s[r1][c1];
    }
}
