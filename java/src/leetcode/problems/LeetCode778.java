package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 16:22
 */
public class LeetCode778 {

    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = grid[0][0];
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        heap.add(new int[]{0, 0, grid[0][0]});
        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            int x = node[0];
            int y = node[1];
            int c = node[2];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (x == n - 1 && y == m - 1) {
                // 常见剪枝
                // 发现终点直接返回
                // 不用等都结束
                return c;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + move[i];
                int ny = y + move[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    int nc = Math.max(c, grid[nx][ny]);
                    if (nc < distance[nx][ny]) {
                        distance[nx][ny] = nc;
                        heap.add(new int[]{nx, ny, nc});
                    }
                }
            }
        }
        return -1;
    }
}
