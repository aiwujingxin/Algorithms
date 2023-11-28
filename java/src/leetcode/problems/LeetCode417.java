package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 22:37
 */
public class LeetCode417 {

    //https://leetcode.cn/problems/pacific-atlantic-water-flow/solution/java-si-lu-qing-xi-dai-ma-jian-ji-by-ven-4cds/

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int col = 0; col < n; col++) {
            dfs(0, col, m, n, pac, heights[0][col], heights);
            dfs(m - 1, col, m, n, atl, heights[m - 1][col], heights);
        }

        for (int row = 0; row < m; row++) {
            dfs(row, 0, m, n, pac, heights[row][0], heights);
            dfs(row, n - 1, m, n, atl, heights[row][n - 1], heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        return result;
    }

    private void dfs(int row, int col, int rows, int cols, boolean[][] visited, int prevHeight, int[][] heights) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(row + 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row - 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col + 1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col - 1, rows, cols, visited, heights[row][col], heights);
    }
}
