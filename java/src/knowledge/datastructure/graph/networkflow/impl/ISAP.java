package knowledge.datastructure.graph.networkflow.impl;

import knowledge.datastructure.graph.networkflow.MaxFlow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 17:59
 */
public class ISAP implements MaxFlow {

    private static class ISAPCore {
        final int N;
        final List<List<Edge>> g;
        final int[] dist; // 到汇点的距离标号（可能为 -1 表示不可达）
        final int[] cnt;  // 各层节点计数（仅统计 dist>=0 的层）
        final int[] cur;  // 当前弧

        ISAPCore(int n) {
            this.N = n;
            g = new ArrayList<>(n);
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());
            dist = new int[n];
            cnt = new int[n + 1];
            cur = new int[n];
        }

        void addEdge(int u, int v, int cap) {
            Edge a = new Edge(v, g.get(v).size(), cap);
            Edge b = new Edge(u, g.get(u).size(), 0);
            g.get(u).add(a);
            g.get(v).add(b);
        }

        // 反向 BFS 从 t，初始化 dist（不可达为 -1）
        void bfsFromT(int t) {
            Arrays.fill(dist, -1);
            Arrays.fill(cnt, 0);
            ArrayDeque<Integer> q = new ArrayDeque<>();
            dist[t] = 0;
            q.add(t);
            while (!q.isEmpty()) {
                int u = q.poll();
                cnt[dist[u]]++;
                for (Edge e : g.get(u)) {
                    Edge rev = g.get(e.to).get(e.rev);
                    if (dist[e.to] == -1 && rev.residual() > 0) {
                        dist[e.to] = dist[u] + 1;
                        q.add(e.to);
                    }
                }
            }
        }

        int maxFlowISAP(int s, int t) {
            bfsFromT(t);
            if (dist[s] == -1) return 0; // 源不可达汇点
            Arrays.fill(cur, 0);
            int flow = 0;
            int[] pathNode = new int[N];
            int[] pathEdgeIdx = new int[N];
            int top = 0;
            int u = s;
            while (dist[s] < N) {
                if (u == t) {
                    // 回溯增广
                    int add = Integer.MAX_VALUE;
                    for (int i = 0; i < top; i++) {
                        Edge e = g.get(pathNode[i]).get(pathEdgeIdx[i]);
                        add = Math.min(add, e.residual());
                    }
                    for (int i = 0; i < top; i++) {
                        Edge e = g.get(pathNode[i]).get(pathEdgeIdx[i]);
                        e.flow += add;
                        g.get(e.to).get(e.rev).flow -= add;
                    }
                    flow += add;
                    // 重新从源开始
                    u = s;
                    top = 0;
                    continue;
                }
                boolean advanced = false;
                // 只有 dist[u] >= 0 的节点参与推进
                if (dist[u] >= 0) {
                    for (int i = cur[u]; i < g.get(u).size(); i++) {
                        Edge e = g.get(u).get(i);
                        if (e.residual() > 0 && dist[e.to] >= 0 && dist[u] == dist[e.to] + 1) {
                            cur[u] = i;
                            pathNode[top] = u;
                            pathEdgeIdx[top] = i;
                            top++;
                            u = e.to;
                            advanced = true;
                            break;
                        }
                    }
                }
                if (!advanced) {
                    // relabel：若 dist[u] < 0（不可达），直接标记为 N，跳过计数更新
                    int old = dist[u];
                    if (old >= 0) {
                        cnt[old]--;
                        if (cnt[old] == 0) {
                            // gap cut：若某层为空，直接终止
                            dist[s] = N;
                            break;
                        }
                    }
                    int minDist = N - 1;
                    for (Edge e : g.get(u)) {
                        if (e.residual() > 0 && dist[e.to] >= 0) {
                            minDist = Math.min(minDist, dist[e.to]);
                        }
                    }
                    if (minDist == N - 1) {
                        dist[u] = N; // 与汇点断开
                    } else {
                        dist[u] = minDist + 1;
                        cnt[dist[u]]++;
                    }
                    cur[u] = 0;
                    // 回退一步（仅当不是源点）
                    if (u != s) {
                        if (top > 0) {
                            top--;
                            u = pathNode[top];
                        } else {
                            u = s;
                            top = 0;
                        }
                    } else {
                        // u==s，无路可走，下一轮继续
                    }
                }
            }
            return flow;
        }
    }

    public ISAP() {
    }

    @Override
    public int maxFlow(int n, int[][] edges) {
        int S = 2 * n, T = 2 * n + 1, V = 2 * n + 2;
        ISAPCore core = new ISAPCore(V);
        for (int u = 0; u < n; u++) core.addEdge(S, u, 1);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (u < 0 || u >= n || v < 0 || v >= n)
                throw new IllegalArgumentException("Edge out of range: (" + u + "," + v + ")");
            core.addEdge(u, n + v, 1);
        }
        for (int v = 0; v < n; v++) core.addEdge(n + v, T, 1);
        return core.maxFlowISAP(S, T);
    }
}
