package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 18:50
 */
public class LeetCode2662_dij {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int res = dist(start[0], start[1], target[0], target[1]);
        int n = specialRoads.length;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                int i = pos[0];
                int costI = pos[1];
                if (costI > dist[i]) {
                    continue;
                }
                int x2i = (i == n ? start[0] : specialRoads[i][2]);
                int y2i = (i == n ? start[1] : specialRoads[i][3]);
                for (int j = 0; j < n; j++) {
                    int x1j = specialRoads[j][0];
                    int y1j = specialRoads[j][1];
                    int x2j = specialRoads[j][2];
                    int y2j = specialRoads[j][3];
                    int costJ = specialRoads[j][4];
                    dist[j] = Math.min(dist[j], costI + dist(x2i, y2i, x2j, y2j));
                    int take = costI + costJ + dist(x2i, y2i, x1j, y1j);
                    if (take < dist[j]) {
                        dist[j] = take;
                        queue.add(new int[]{j, take});
                        res = Math.min(res, take + dist(x2j, y2j, target[0], target[1]));
                    }
                }
            }
        }
        return res;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

}
