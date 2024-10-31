package knowledge.datastructure.graph.connectivity.undirected;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wujingxinit@outlook.com
 * @date 10/31/24 22:54
 * @description 割点
 */
public class TarjanPoint {

    private List<Integer>[] graph;      // 图的邻接表表示
    private boolean[] vis, isCut;       // 访问标记, 标记割点
    private int[] dfn, low;             // 记录节点的发现时间,记录节点的 low 值
    private int time;                   // DFS 时间戳

    public List<Integer> findCutPoints(int n, List<Integer>[] graph) {
        this.graph = graph;
        this.vis = new boolean[n];
        this.dfn = new int[n];
        this.low = new int[n];
        this.isCut = new boolean[n];
        this.time = 0;
        // 从每个未访问的节点开始 DFS，防止图不连通的情况
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfs(i, i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < isCut.length; i++) {
            if (isCut[i]) {
                result.add(i);
            }
        }
        return result;
    }

    private void dfs(int u, int pa) {
        vis[u] = true;
        dfn[u] = low[u] = ++time;
        int child = 0;
        for (int v : graph[u]) {
            if (!vis[v]) {
                child++;
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                // 非根节点 当且仅当 u 存在 一个子节点 v，v 及其后代都没有回退边连回 u 的祖先
                if (low[v] >= dfn[u] && pa != u) {
                    isCut[u] = true;
                }
            } else if (dfn[v] < dfn[u] && v != pa) {  // 更新 low 值（反向边）
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
        // 根节点至少2个儿子
        if (pa == u && child >= 2) {
            isCut[u] = true;
        }
    }

    public static void main(String[] args) {
        List<Integer>[] graph = new List[5];
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(2);
        graph[1].add(3);
        graph[3].add(4);
        List<Integer> cutPoints = new TarjanPoint().findCutPoints(5, graph);
        System.out.println("Cut Points: " + cutPoints);
    }
}