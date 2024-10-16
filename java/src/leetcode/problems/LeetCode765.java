package leetcode.problems;

import knowledge.datastructure.adv.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/5 19:11
 */
public class LeetCode765 {

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int k = n / 2;
        UnionFind uf = new UnionFind(k);
        for (int i = 0; i < n; i += 2) {
            uf.union(row[i] / 2, row[i + 1] / 2);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int fx = uf.find(i);
            map.put(fx, map.getOrDefault(fx, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += entry.getValue() - 1;
        }
        return res;
    }
}
