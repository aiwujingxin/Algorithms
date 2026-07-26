package leetcode.problems;

import knowledge.datastructure.adv.UnionFind;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 10:49
 */
public class LeetCode2316 {

    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) uf.union(edge[0], edge[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(uf.find(i), 1, Integer::sum);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res += (long) e.getValue() * (n - e.getValue());
        }
        return res / 2;
    }
}
