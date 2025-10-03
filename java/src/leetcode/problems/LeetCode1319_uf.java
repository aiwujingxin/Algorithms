package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 22:11
 */
public class LeetCode1319_uf {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        return uf.getCount() - 1;
    }
}