package leetcode.problems;

import basic.datastructure.advance.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:44
 */
public class LeetCode2492_uf {

    //路径可重复走，则我们只需要获取每一个“组”内路径分数的最小值，即为这个组内的任意量节点之间的路径分数最小值（理解这点是解题的关键）
    //要将个节点根据连接关系分组，则可以采用并查集 + 哈希表
    public int minScore(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n + 1);
        for (int[] r : roads) {
            uf.unionByRank(r[0], r[1]);
        }
        for (int[] road : roads) {
            int pa = uf.find(road[0]);
            map.put(pa, Math.min(map.getOrDefault(pa, Integer.MAX_VALUE), road[2]));
        }
        return map.get(uf.find(1));
    }
}
