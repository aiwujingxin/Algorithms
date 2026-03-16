package knowledge.datastructure.graph.connectivity.hascycle;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 3/16/26 23:53
 * @description 无向图判环
 */
public class HasCycle_uf {

    public boolean hasCycle(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) {
                return true;
            }
        }
        return false;
    }
}
