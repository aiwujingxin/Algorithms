package leetcode;

import basic.datastructure.advance.*;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 17:35
 */
public class LeetCode1584_Kruskal {

    /**
     * 每次都选择一条权重最小的边加入到森林
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new int[]{findDist(points, i, j), i, j});
            }
        }
        int count = 0;
        UnionFind uf = new UnionFind(n);
        while (count < n - 1) {
            int[] edge = pq.poll();
            if (uf.find(edge[1]) != uf.find(edge[2])) {
                ans += edge[0];
                count++;
                uf.union(edge[1], edge[2]);
            }
        }
        return ans;
    }

    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

}
