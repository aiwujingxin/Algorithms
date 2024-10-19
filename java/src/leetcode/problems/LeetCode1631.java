package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 22:41
 */
public class LeetCode1631 {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int curX = node[0];
            int curY = node[1];
            int curCost = node[2];
            if (curX == m - 1 && curY == n - 1) {
                return curCost;
            }
            if (curCost > cost[curX][curY]) {
                continue;
            }
            for (int[] ne : getNext(heights, curX, curY)) {
                int nx = ne[0];
                int ny = ne[1];
                int w = Math.max(cost[curX][curY], Math.abs(heights[curX][curY] - heights[nx][ny]));
                if (cost[nx][ny] > w) {
                    cost[nx][ny] = w;
                    pq.add(new int[]{nx, ny, w});
                }
            }
        }
        return -1;
    }

    List<int[]> getNext(int[][] matrix, int x, int y) {
        int m = matrix.length, n = matrix[0].length;
        List<int[]> nexts = new ArrayList<>();
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                continue;
            }
            nexts.add(new int[]{nx, ny});
        }
        return nexts;
    }
}
