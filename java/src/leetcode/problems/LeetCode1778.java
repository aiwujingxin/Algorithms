package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 16:53
 */
public class LeetCode1778 {
    char[] charDirs = {'U', 'D', 'L', 'R'};
    char[] reCharDirs = {'D', 'U', 'R', 'L'};
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean find = false;
    int targetX, targetY;
    boolean[][] nodes = new boolean[1000][1000];

    public int findShortestPath(GridMaster master) {
        //起点就是目的地
        if (master.isTarget()) {
            return 0;
        }
        dfs(master, 500, 500);
        if (!find) {
            return -1;
        }
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[1000][1000];
        que.offer(new int[]{500, 500});
        int ans = 0;
        visited[500][500] = true;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] curr = que.poll();
                int x = curr[0];
                int y = curr[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + directions[d][0];
                    int ny = y + directions[d][1];
                    if (nx < 0 || ny < 0 || nx >= 1000 || ny >= 1000) {
                        continue;
                    }
                    if (!nodes[nx][ny] || visited[nx][ny]) {
                        continue;
                    }
                    if (nx == targetX && ny == targetY) {
                        return ans + 1;
                    }
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
            ans++;
        }
        return ans;

    }

    void dfs(GridMaster master, int x, int y) {
        //已经访问过(x,y);
        if (nodes[x][y]) {
            return;
        }
        nodes[x][y] = true;
        if (master.isTarget()) {
            targetX = x;
            targetY = y;
            find = true;
        }
        for (int i = 0; i < 4; i++) {
            //四个方向尝试能够走通
            if (master.canMove(charDirs[i])) {
                master.move(charDirs[i]);
                dfs(master, x + directions[i][0], y + directions[i][1]);
                master.move(reCharDirs[i]);
            }
        }
    }


    static class GridMaster {
        boolean canMove(char direction) {
            return true;
        }

        void move(char direction) {
        }

        boolean isTarget() {
            return true;
        }
    }
}
