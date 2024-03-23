package leetcode.problems;

import knowledge.datastructure.advanced.UnionFind;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 22:11
 */
public class LeetCode1319_uf {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }
        return unionFind.getCount() - 1;
    }
}