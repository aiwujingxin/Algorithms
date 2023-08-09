package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/22 22:37
 */
public class LeetCode505_bfs {

    // 最短路径
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        if (maze == null || maze.length == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();

        int[][] dist = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        queue.add(new int[]{start[0], start[1], 0});

        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            for (int[] d : dist) {
                int x = node[0] + d[0];
                int y = node[1] + d[1];
                int count = 0;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x = x + d[0];
                    y = y + d[1];
                    count++;
                }
                if (distance[node[0]][node[1]] + count < distance[x - d[0]][y - d[1]]) {
                    distance[x - d[0]][y - d[1]] = distance[node[0]][node[1]] + count;
                    queue.add(new int[]{x - d[0], y - d[1]});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
