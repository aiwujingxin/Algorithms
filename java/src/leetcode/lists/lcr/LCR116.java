package leetcode.lists.lcr;

import knowledge.advstructure.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 15:39
 */
public class LCR116 {

    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind(isConnected.length);
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
