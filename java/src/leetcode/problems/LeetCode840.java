package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/27 12:38
 */
public class LeetCode840 {

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m < 3 || n < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 5) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        continue;
                    }
                    if (check(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean check(int[][] grid, int i, int j) {
        int rowStart = i - 1;
        int colStart = j - 1;
        HashSet<Integer> set = new HashSet<>();

        for (int k = rowStart; k < rowStart + 3; k++) {
            int sum = 0;
            for (int l = colStart; l < colStart + 3; l++) {
                if (grid[k][l] <= 0 || grid[k][l] >= 10) {
                    return false;
                }
                sum += grid[k][l];
                set.add(grid[k][l]);
            }
            if (sum != 15) {
                return false;
            }
        }
        if (set.size() != 9) {
            return false;
        }
        for (int l = colStart; l < colStart + 3; l++) {
            int sum = 0;
            for (int k = rowStart; k < rowStart + 3; k++) {
                sum += grid[k][l];
            }
            if (sum != 15) {
                return false;
            }
        }

        int sum = 0;
        int l = colStart;
        for (int k = rowStart; k < rowStart + 3; k++) {
            sum += grid[k][l];
            l++;
        }
        if (sum != 15) {
            return false;
        }
        sum = 0;
        int k = rowStart;
        for (int ll = colStart + 2; ll >= colStart; ll--) {
            sum += grid[k][ll];
            k++;
        }
        return sum == 15;
    }
}
