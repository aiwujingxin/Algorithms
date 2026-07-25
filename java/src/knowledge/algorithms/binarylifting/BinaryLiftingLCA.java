package knowledge.algorithms.binarylifting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 倍增求最近公共祖先 (Binary Lifting LCA)
 * <适用场景>
 * 静态树上大量查询两点 LCA、树上第 K 祖先、两点距离。O(n log n) 预处理，单次查询 O(log n)。
 * <核心>
 * up[v][j] 表示 v 向上跳 2^j 步到达的祖先，由 up[v][j] = up[up[v][j-1]][j-1] 倍增合并。
 * 求 LCA 先把较深点提到同一深度，再让两点一起按 2 的幂次尝试上跳，跳到 LCA 的两个孩子处停下。
 * @see SparseTable 同为倍增思想的区间最值结构
 */
public class BinaryLiftingLCA {

    private final int LOG;
    private final int[] depth;
    private final int[][] up;
    private final List<List<Integer>> tree;

    public BinaryLiftingLCA(int n, int root, int[][] edges) {
        this.LOG = Math.max(1, (int) (Math.log(n) / Math.log(2)) + 1);
        this.depth = new int[n];
        this.up = new int[n][LOG];
        this.tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(root, root);
    }

    private void dfs(int node, int parent) {
        up[node][0] = parent;
        for (int j = 1; j < LOG; j++) {
            up[node][j] = up[up[node][j - 1]][j - 1];
        }
        for (int next : tree.get(node)) {
            if (next != parent) {
                depth[next] = depth[node] + 1;
                dfs(next, node);
            }
        }
    }

    /**
     * 返回 node 的第 k 个祖先，超出根返回 root（up[root][*]=root 自环）。
     */
    public int kthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
            }
        }
        return node;
    }

    /**
     * 返回 u、v 的最近公共祖先。
     */
    public int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        // 先把较深的 u 提到与 v 同深度
        u = kthAncestor(u, depth[u] - depth[v]);
        if (u == v) return u;
        // 两点一起上跳，跳到 LCA 的正下方
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    /**
     * 树上两点间的边数（距离）。
     */
    public int distance(int u, int v) {
        return depth[u] + depth[v] - 2 * depth[lca(u, v)];
    }
}
