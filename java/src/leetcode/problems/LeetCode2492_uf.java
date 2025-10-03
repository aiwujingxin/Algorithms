package leetcode.problems;

import knowledge.datastructure.adv.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:44
 * @description 即和1在一个连通块里面的所有边中最小的一个
 */
public class LeetCode2492_uf {

    public int minScore(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n + 1);
        for (int[] r : roads) {
            uf.union(r[0], r[1]);
        }
        for (int[] road : roads) {
            int pa = uf.find(road[0]);
            map.put(pa, Math.min(map.getOrDefault(pa, Integer.MAX_VALUE), road[2]));
        }
        return map.get(uf.find(1));
    }
}
