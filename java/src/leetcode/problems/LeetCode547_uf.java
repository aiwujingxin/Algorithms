package leetcode.problems;

import knowledge.advstructure.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 20:28
 */
public class LeetCode547_uf {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }
}
