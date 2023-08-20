package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 16:49
 */
public class LeetCode490_dfs {

    int row, col;

    public boolean hasPath(int[][] maze, int[] st, int[] end) {
        row = maze.length;
        col = maze[0].length;
        boolean[][] vis = new boolean[row][col];
        return dfs(st, end, vis, maze);
    }

    public boolean dfs(int[] st, int[] end, boolean[][] vis, int[][] maze) {
        if (st[0] < 0 || st[1] < 0 || st[0] >= row || st[1] >= col || vis[st[0]][st[1]]) {
            return false;
        }

        if (st[0] == end[0] && st[1] == end[1]) {
            return true;
        }

        vis[st[0]][st[1]] = true;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] d : dir) {
            int nx = st[0] + d[0], ny = st[1] + d[1];
            while (nx >= 0 && ny >= 0 && nx < row && ny < col && maze[nx][ny] == 0) {
                nx += d[0];
                ny += d[1];
            }
            if (dfs(new int[]{nx - d[0], ny - d[1]}, end, vis, maze)) {
                return true;
            }
        }
        return false;
    }
}
