package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 14:49
 */
public class LeetCode417 {

    int m;
    int n;

    int[][] heights;

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;

        List<List<Integer>> list = new ArrayList<>();
        boolean[][] a = new boolean[m][n];
        boolean[][] b = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, a);
            dfs(i, n - 1, b);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, a);
            dfs(m - 1, i, b);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] && b[i][j]) {
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    list.add(t);
                }
            }
        }
        return list;
    }

    private void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) {
                continue;
            }
            if (heights[nx][ny] < heights[i][j]) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny, visited);
        }
    }
}
