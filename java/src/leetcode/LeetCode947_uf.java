package leetcode;

import basic.datastructure.advance.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 16:06
 */
public class LeetCode947_uf {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(n);
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> row = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            col.putIfAbsent(x, i);
            row.putIfAbsent(y, i);
            unionFind.union(col.get(x), i);
            unionFind.union(row.get(y), i);
        }
        return n - unionFind.getCount();
    }
}
