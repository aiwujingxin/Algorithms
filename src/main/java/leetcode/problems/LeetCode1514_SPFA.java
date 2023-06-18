package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 22:02
 */
public class LeetCode1514_SPFA {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] g = new List[n];
        boolean[] s = new boolean[n];
        double[] dist = new double[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        //构建邻接表无向图
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            g[x].add(new double[]{y, succProb[i]});
            g[y].add(new double[]{x, succProb[i]});
        }
        dist[start] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        s[start] = true;
        while (!q.isEmpty()) {
            int root = q.poll();
            s[root] = false;
            //用队列中的点更新于这个点关联的其他点
            for (double[] d : g[root]) {
                double temp = d[1];
                int x = (int) (d[0] * 1);
                if (dist[x] < dist[root] * temp) {
                    dist[x] = dist[root] * temp;
                    if (!s[x]) {
                        s[x] = true;
                        q.offer(x);
                    }
                }
            }
        }
        return dist[end];
    }
}
