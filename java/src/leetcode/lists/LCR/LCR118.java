package leetcode.lists.LCR;

import basic.datastructure.advance.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 15:40
 */
public class LCR118 {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }
}
