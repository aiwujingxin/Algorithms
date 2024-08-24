package knowledge.algorithms.dp.backpack.depend;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 00:29
 * @description 依赖关系是一个森林
 * @link <a href="https://www.acwing.com/problem/content/10/">有依赖的背包问题</a>
 * <a href="https://www.acwing.com/solution/content/114805/">有依赖的背包问题|Java|树形dp</a>
 * <a href="https://www.bilibili.com/video/BV1tp4y1k7py/?spm_id_from=333.337.search-card.all.click&vd_source=88e5a3e60377510439e11f13b5878c25">
 */
public class DependPack_treedp implements DependPack {

    int V;
    int root;
    int[][] dp;
    Item[] bag;

    @Override
    public int backPack(int[][] items, int V, int N) {
        this.V = V;
        this.bag = new Item[N + 1];
        this.dp = new int[N + 1][V + 1];
        for (int i = 0; i <= N; i++) {
            bag[i] = new Item();
        }
        for (int i = 1; i <= N; i++) {
            bag[i].v = items[i - 1][0];
            bag[i].w = items[i - 1][1];
            int p = items[i - 1][2];
            if (p == -1) {
                root = i;
            } else {
                bag[p].children.add(i);
            }
        }
        dfs(root);
        return dp[root][V];
    }

    public void dfs(int x) {
        for (int i = bag[x].v; i <= V; i++) {
            dp[x][i] = bag[x].w;
        }
        for (int i = 1; i < bag[x].children.size(); i++) {
            int u = bag[x].children.get(i);
            dfs(u);
            // 分组背包
            for (int j = V; j >= bag[x].v; j--) { // 循环体积
                for (int k = 0; k <= j - bag[x].v; k++) {  // 循环决策
                    dp[x][j] = Math.max(dp[x][j], dp[x][j - k] + dp[u][k]);
                }
            }
        }
    }
}