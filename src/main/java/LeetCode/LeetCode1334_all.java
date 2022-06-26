package LeetCode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 10:30
 */
public class LeetCode1334_all {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = (int) 1e9 + 7;
        List<int[]>[] adj = new List[n];
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int d = e[2];

            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
            // dist[u][v] = d;
            // dist[v][u] = d;
        }

        // floyd(n, adj, dist);
        for (int i = 0; i < n; i++) {
            // dijkstra(n, adj, dist[i], i);
            // bellman(n, edges, dist[i], i);
            spfa(n, adj, dist[i], i);
        }

        int minCity = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (dist[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }
            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }

        return minCity;
    }

    void spfa(int n, List<int[]>[] adj, int[] dist, int src) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] updateTimes = new int[n];
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.removeFirst();
            for (int[] next : adj[u]) {
                int v = next[0];
                int duv = next[1];
                if (dist[v] > dist[u] + duv) {
                    dist[v] = dist[u] + duv;
                    updateTimes[v]++;
                    q.add(v);
                    if (updateTimes[v] > n) {
                        System.out.println("wrong");
                    }
                }
            }
        }
    }

    void bellman(int n, int[][] edges, int[] dist, int src) {
        for (int k = 1; k < n; k++) {
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int duv = e[2];

                if (dist[u] > dist[v] + duv) {
                    dist[u] = dist[v] + duv;
                }

                if (dist[v] > dist[u] + duv) {
                    dist[v] = dist[u] + duv;
                }
            }
        }
    }

    void dijkstra(int n, List<int[]>[] adj, int[] dist, int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int u = cur[0];
            int du = cur[1];
            if (du > dist[u]) {
                continue;
            }

            for (int[] nb : adj[u]) {
                int v = nb[0];
                int duv = nb[1];
                if (dist[v] > du + duv) {
                    dist[v] = du + duv;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
    }

    void floyd(int n, List<int[]>[] adj, int[][] dist) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
