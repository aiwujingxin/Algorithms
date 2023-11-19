package leetcode.problems;

import basic.datastructure.advance.UnionFind;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:02
 */
public class LeetCode684_uf {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            int node1 = edge[0], node2 = edge[1];
            if (!uf.union(node1, node2)) {
                return edge;
            }
        }
        return new int[0];
    }
}

