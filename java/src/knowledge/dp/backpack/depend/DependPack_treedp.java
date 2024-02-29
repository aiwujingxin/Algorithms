package knowledge.dp.backpack.depend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 00:29
 * @description 依赖关系是一个森林
 * @link <a href="https://www.acwing.com/problem/content/10/">有依赖的背包问题</a>
 * <a href="https://www.acwing.com/solution/content/114805/"></a>
 * <a href="https://www.bilibili.com/video/BV1tp4y1k7py/?spm_id_from=333.337.search-card.all.click&vd_source=88e5a3e60377510439e11f13b5878c25">
 */
public class DependPack_treedp implements DependPack {

    int V;
    int root;
    int[][] dp;
    Bag[] graph;

    @Override
    public int backPack(int[][] items, int V, int N) {
        this.V = V;
        this.graph = new Bag[N + 1];
        this.dp = new int[N + 1][V + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new Bag();
        }
        for (int i = 1; i <= N; i++) {
            graph[i].v = items[i - 1][0];
            graph[i].w = items[i - 1][1];
            int p = items[i - 1][2];
            if (p == -1) {
                root = i;
            } else {
                graph[p].list.add(i);
            }
        }
        dfs(root);
        return dp[root][V];
    }

    public void dfs(int x) {
        for (int i = graph[x].v; i <= V; i++) {
            dp[x][i] = graph[x].w;
        }
        for (int i = 1; i < graph[x].list.size(); i++) {
            int u = graph[x].list.get(i);
            dfs(u);
            for (int j = V; j >= graph[x].v; j--) {
                for (int k = 0; k <= j - graph[x].v; k++) {
                    dp[x][j] = Math.max(dp[x][j], dp[x][j - k] + dp[u][k]);
                }
            }
        }
    }

    static class Bag {
        int v, w;
        List<Integer> list;

        public Bag() {
            this.list = new ArrayList<>();
            list.add(0);
        }
    }
}