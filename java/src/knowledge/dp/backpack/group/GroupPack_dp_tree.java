package knowledge.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 00:29
 * <a href="https://www.bilibili.com/video/BV1tp4y1k7py/?spm_id_from=333.337.search-card.all.click&vd_source=88e5a3e60377510439e11f13b5878c25">
 */
public class GroupPack_dp_tree {

    int[] v;
    int[] w;
    int[] b;
    int m;
    int[][] f;
    int[][] a;
    int root;

    int dp() {
        dfs(root);
        return f[root][m];
    }

    void dfs(int u) {
        for (int i = v[u]; i <= m; i++) {
            f[u][i] = w[u];
        }
        for (int i = 0; i < b[u]; i++) {
            int s = a[u][i];
            dfs(s); // 求解子问题
            for (int j = m; j >= v[u]; j--) {
                for (int k = 0; k < j - v[u]; k++) {
                    f[u][j] = Math.max(f[u][j], f[u][j - k] + f[s][k]);
                }
            }
        }
    }
}
