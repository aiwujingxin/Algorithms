package leetcode.problems;

import knowledge.advstructure.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/5 19:11
 */
public class LeetCode765 {

    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < row.length; i++) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return n - unionFind.getCount();
    }
}
