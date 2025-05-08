package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 16:37
 */
public class LeetCode59 {

    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[x][y] = i;
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || ans[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        return ans;
    }
}
