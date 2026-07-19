package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 5/14/26 00:06
 */
public class LeetCode1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid[0].length;
        for (int i = 0; i < m / 2 - 1; i++) {
            cal(grid, i, k);
        }
        return grid;
    }

    private void cal(int[][] grid, int i, int k) {
        int m = grid.length - i;
        int n = grid[0].length - i;
        int len = (grid.length - 2 * i + grid[0].length - 2 * i - 2) * 2;
        if (len == 0) return;
        k = k % len;
        if (k == 0) return;
        List<Integer> list = new ArrayList<>();
        int row = i;
        int col = i;
        for (; row < m; row++) {
            list.add(grid[row][col]);
        }
        row--;
        col++;
        for (; col < n; col++) {
            list.add(grid[row][col]);
        }
        col--;
        row--;
        for (; row >= i; row--) {
            list.add(grid[row][col]);
        }
        row++;
        col--;
        for (; col > i; col--) {
            list.add(grid[row][col]);
        }
        int index = len - k;
        row = i;
        col = i;
        for (; row < m; row++) {
            grid[row][col] = list.get(index);
            index = (index + 1 + len) % len;
        }
        row--;
        col++;
        for (; col < n; col++) {
            grid[row][col] = list.get(index);
            index = (index + 1 + len) % len;
        }
        col--;
        row--;
        for (; row >= i; row--) {
            grid[row][col] = list.get(index);
            index = (index + 1 + len) % len;
        }
        row++;
        col--;
        for (; col > i; col--) {
            grid[row][col] = list.get(index);
            index = (index + 1 + len) % len;
        }
    }
}
