package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/26 15:53
 */
public class LeetCode499_bfs {


    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

        int n = maze.length;
        int m = maze[0].length;
        String[][] way = new String[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(way[i], "");
        }

        int[][] dp = new int[n][m];
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        String[] dirs = new String[]{"u", "d", "l", "r"};
        //构造队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(ball);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int nx = cur[0], ny = cur[1];
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && maze[nx][ny] == 0) {
                    if (nx == hole[0] && ny == hole[1]) {
                        nx += dx[direction];
                        ny += dy[direction];
                        break;
                    }
                    nx += dx[direction];
                    ny += dy[direction];
                }
                nx -= dx[direction];
                ny -= dy[direction];
                int steps = dp[cur[0]][cur[1]] + Math.abs(nx - cur[0]) + Math.abs(ny - cur[1]);
                //非当前位置，未初始化，路径长度小于当前位置的原来的值，路径长度相等，字典序更小
                if (!(nx == cur[0] && ny == cur[1]) && (dp[nx][ny] == 0 || (dp[nx][ny] > steps || (dp[nx][ny] == steps && (way[cur[0]][cur[1]] + dirs[direction]).compareTo(way[nx][ny]) < 0)))) {
                    dp[nx][ny] = steps;
                    way[nx][ny] = way[cur[0]][cur[1]] + dirs[direction];
                    if (!(nx == hole[0] && ny == hole[1])) {
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return way[hole[0]][hole[1]].equals("") ? "impossible" : way[hole[0]][hole[1]];
    }
}
