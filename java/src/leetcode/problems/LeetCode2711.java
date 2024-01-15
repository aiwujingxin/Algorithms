package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 17:19
 */
public class LeetCode2711 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = cal(grid, i, j);
            }
        }
        return answer;
    }

    private int cal(int[][] grid, int r, int c) {
        HashSet<Integer> topLeft = new HashSet<>();
        int i = r - 1;
        int j = c - 1;
        while (i >= 0 && j >= 0) {
            topLeft.add(grid[i][j]);
            i--;
            j--;
        }
        HashSet<Integer> bottomRight = new HashSet<>();
        int k = r + 1;
        int l = r + 1;

        while (i <= grid.length && l <= grid[0].length) {
            bottomRight.add(grid[k][l]);
            k++;
            l++;
        }
        return Math.abs(topLeft.size() - bottomRight.size());
    }
}
