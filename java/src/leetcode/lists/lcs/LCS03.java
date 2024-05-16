package leetcode.lists.lcs;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/5/15 22:20
 */
public class LCS03 {

    boolean[][] isZou;
    boolean[][] visited;

    public int largestArea(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int[][] mat = new int[m][n];
        visited = new boolean[m][n];
        isZou = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = grid[i].charAt(j) - '0';
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1 || mat[i][j] == 0) {
                    isZou[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isZou[i][j]) {
                    merge(mat, i, j, mat[i][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isZou[i][j]) {
                    res = Math.max(res, count(mat, i, j, mat[i][j]));
                }
            }
        }
        return res;
    }

    private void merge(int[][] mat, int i, int j, int pa) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (pa == 0 || mat[i][j] == pa) {
            isZou[i][j] = true;
            merge(mat, i + 1, j, mat[i][j]);
            merge(mat, i - 1, j, mat[i][j]);
            merge(mat, i, j + 1, mat[i][j]);
            merge(mat, i, j - 1, mat[i][j]);
        }
        visited[i][j] = false;
    }

    private int count(int[][] mat, int i, int j, int pa) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || isZou[i][j] || mat[i][j] != pa || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = 1;
        res += count(mat, i + 1, j, mat[i][j]);
        res += count(mat, i - 1, j, mat[i][j]);
        res += count(mat, i, j + 1, mat[i][j]);
        res += count(mat, i, j - 1, mat[i][j]);
        return res;
    }
}
