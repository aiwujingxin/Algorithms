package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 11/25/25 17:04
 */
public class LeetCode2087 {

    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    final static int INF = 0x3f3f3f3f;

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int m = rowCosts.length;
        int n = colCosts.length;
        int[][] d = new int[m][n];
        for (int[] r : d) {
            Arrays.fill(r, INF);
        }
        d[startPos[0]][startPos[1]] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{startPos[0], startPos[1], 0});
        while (!pq.isEmpty()) {
            int[] u = pq.poll();
            for (int[] dir : dirs) {
                int ni = u[0] + dir[0];
                int nj = u[1] + dir[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;
                int w = dir[1] == 0 ? rowCosts[nj] : colCosts[ni];
                if (d[ni][nj] > d[u[0]][u[1]] + w) {
                    d[ni][nj] = d[u[0]][u[1]] + w;
                    pq.add(new int[]{ni, nj, d[ni][nj]});
                }
            }
        }
        return d[homePos[0]][homePos[1]];
    }
}
