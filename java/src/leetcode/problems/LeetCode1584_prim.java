package leetcode.problems;

import java.util.HashSet;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 14:30
 */
public class LeetCode1584_prim {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length, ans = 0;
        HashSet<Integer> mst = new HashSet<>();
        mst.add(0);
        // build graph
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            dist[i] = calculateDist(points, 0, i);
        }
        while (mst.size() != n) {
            // Find the node that has the shortest distance
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (mst.contains(i)) {
                    continue;
                }
                if (next == -1 || dist[next] > dist[i]) {
                    next = i;
                }
            }

            // Put the node into the Minning Spanning Tree
            mst.add(next);
            ans += dist[next];
            // Update distance array
            for (int i = 0; i < n; i++) {
                if (!mst.contains(i)) {
                    dist[i] = Math.min(dist[i], calculateDist(points, i, next));
                }
            }
        }
        return ans;
    }

    private int calculateDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
