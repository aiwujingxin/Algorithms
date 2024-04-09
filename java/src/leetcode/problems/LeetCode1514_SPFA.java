package leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 22:02
 */
public class LeetCode1514_SPFA {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new List[n];
        boolean[] vis = new boolean[n];
        double[] dist = new double[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            graph[x].add(new double[]{y, succProb[i]});
            graph[y].add(new double[]{x, succProb[i]});
        }
        dist[start] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) {
            int root = q.poll();
            vis[root] = false;
            //用队列中的点更新于这个点关联的其他点
            for (double[] d : graph[root]) {
                double w = d[1];
                int x = (int) (d[0] * 1);
                if (dist[x] < dist[root] * w) {
                    dist[x] = dist[root] * w;
                    if (!vis[x]) {
                        q.add(x);
                        vis[x] = true;
                    }
                }
            }
        }
        return dist[end];
    }
}
