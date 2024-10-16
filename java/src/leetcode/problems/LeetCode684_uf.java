package leetcode.problems;

import knowledge.datastructure.adv.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:02
 */
public class LeetCode684_uf {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }
}

