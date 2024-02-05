package leetcode.problems;

import knowledge.advstructure.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:07
 */
public class LeetCode2316 {

    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        if (uf.getCount() == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p1 = uf.find(i);
            map.put(p1, map.getOrDefault(p1, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += (long) entry.getValue() * (n - (long) entry.getValue());
        }
        return res;
    }
}
