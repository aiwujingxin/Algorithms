package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 14:04
 */
public class LeetCode3341 {

    public int minTimeToReach(int[][] moveTime) {
        final int INF = 0x3f3f3f3f;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] d = new int[m][n];
        for (int[] t : d) {
            Arrays.fill(t, INF);
        }
        d[0][0] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            for (int[] dir : dirs) {
                int x = u[0] + dir[0];
                int y = u[1] + dir[1];
                if (x < 0 || x >= m || y < 0 | y >= n)
                    continue;
                int w;
                if (u[2] >= moveTime[x][y]) {
                    w = 1;
                } else {
                    w = moveTime[x][y] - u[2] + 1;
                }
                if (d[x][y] > d[u[0]][u[1]] + w) {
                    d[x][y] = d[u[0]][u[1]] + w;
                    pq.add(new int[]{x, y, d[x][y]});
                }
            }
        }
        return d[m - 1][n - 1];
    }
}
