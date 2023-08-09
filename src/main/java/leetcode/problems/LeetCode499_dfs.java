package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 16:52
 */
public class LeetCode499_dfs {

    String res = "";

    int minleng = Integer.MAX_VALUE;

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] directions = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        int m = maze.length;
        if (m == 0) return res;
        int n = maze[0].length;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }
        vis[ball[0]][ball[1]] = 0;
        char[] direct = new char[]{'d', 'l', 'r', 'u'};
        dfs(maze, ball, hole, new StringBuilder(), directions, direct, m, n, vis, -1, 0);
        if (res.length() > 0) {
            return res;
        }
        return "impossible";
    }

    public void dfs(int[][] maze, int[] ball, int[] hole, StringBuilder sb, int[][] directions, char[] direct, int m, int n, int[][] vis, int prev, int step) {
        for (int i = 0; i < 4; i++) {
            int x = ball[0];
            int y = ball[1];
            int currstep = step;
            // 只能转弯 不能掉头
            if ((prev == 0 && i == 3) || (prev == 1 && i == 2) || (prev == 2 && i == 1) || (prev == 3 && i == 0) || (i == prev)) {
                continue;
            }
            while (x + directions[i][0] >= 0 && x + directions[i][0] < m && y + directions[i][1] >= 0 && y + directions[i][1] < n && maze[x + directions[i][0]][y + directions[i][1]] != 1) {
                x += directions[i][0];
                y += directions[i][1];
                currstep++;
                if (currstep >= minleng) {
                    return;
                }
                if (x == hole[0] && y == hole[1]) {
                    res = String.valueOf(sb) + direct[i];
                    minleng = currstep;
                    return;
                }
            }
            if ((x != ball[0] || y != ball[1]) && vis[x][y] > currstep) {
                sb.append(direct[i]);
                vis[x][y] = currstep;
                dfs(maze, new int[]{x, y}, hole, sb, directions, direct, m, n, vis, i, currstep);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
