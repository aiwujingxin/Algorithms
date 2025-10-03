package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:19
 */
public class LeetCode3613 {

    public int minCost(int n, int[][] edges, int k) {
        if (k == n) {
            return 0;
        }
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            l = Math.min(l, edge[2]);
            r = Math.max(r, edge[2]);
        }
        while (l < r) {
            int m = l + r >> 1;
            if (check(n, edges, k, m)) r = m;
            else l = m + 1;
        }
        return l;
    }

    public boolean check(int n, int[][] edges, int k, int threshold) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w <= threshold && uf.union(u, v) && uf.getCount() <= k) {
                return true;
            }
        }
        return false;
    }
}
