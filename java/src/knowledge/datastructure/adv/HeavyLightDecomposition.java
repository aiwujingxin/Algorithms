package knowledge.datastructure.adv;

import java.util.ArrayList;
import java.util.List;

/**
 * Heavy-Light Decomposition (树链剖分)
 * Used to transform tree paths into segments to query/update in O(log^2 N) time using a Segment Tree.
 */
public class HeavyLightDecomposition {
    private List<List<Integer>> tree;
    private int[] parent, depth, size, heavy, head, pos;
    private int currentPos;

    /**
     * Initializes HLD for a tree with n nodes.
     *
     * @param n The number of nodes in the tree
     */
    public HeavyLightDecomposition(int n) {
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        parent = new int[n + 1];
        depth = new int[n + 1];
        size = new int[n + 1];
        heavy = new int[n + 1];
        head = new int[n + 1];
        pos = new int[n + 1];
        currentPos = 0;
    }

    /**
     * Adds an undirected edge between u and v.
     *
     * @param u Node u
     * @param v Node v
     */
    public void addEdge(int u, int v) {
        tree.get(u).add(v);
        tree.get(v).add(u);
    }

    /**
     * Builds the Heavy-Light Decomposition structure.
     *
     * @param root The root of the tree
     */
    public void build(int root) {
        dfs1(root, 0, 1);
        dfs2(root, root);
    }

    private void dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        size[u] = 1;
        heavy[u] = 0;
        int maxSubSize = 0;

        for (int v : tree.get(u)) {
            if (v != p) {
                dfs1(v, u, d + 1);
                size[u] += size[v];
                if (size[v] > maxSubSize) {
                    maxSubSize = size[v];
                    heavy[u] = v;
                }
            }
        }
    }

    private void dfs2(int u, int h) {
        head[u] = h;
        pos[u] = ++currentPos;

        if (heavy[u] != 0) {
            dfs2(heavy[u], h);
        }

        for (int v : tree.get(u)) {
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    /**
     * Returns the lowest common ancestor (LCA) of u and v.
     *
     * @param u Node u
     * @param v Node v
     * @return The LCA of u and v
     */
    public int lca(int u, int v) {
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            u = parent[head[u]];
        }
        return depth[u] < depth[v] ? u : v;
    }
}
