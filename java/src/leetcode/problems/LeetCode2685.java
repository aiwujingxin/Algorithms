package leetcode.problems;


import knowledge.datastructure.adv.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:27
 */
public class LeetCode2685 {

    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        // 连通分量点个数
        Map<Integer, Integer> pointCnt = new HashMap<>();
        // 连通分量边个数
        Map<Integer, Integer> edgeCnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            pointCnt.put(parent, pointCnt.getOrDefault(parent, 0) + 1);
            edgeCnt.put(parent, edgeCnt.getOrDefault(parent, 0) + graph.get(i).size());
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : pointCnt.entrySet()) {
            //e==v*(v-1)
            int num = entry.getValue() * (entry.getValue() - 1) / 2;
            if (num == edgeCnt.get(entry.getKey())) {
                ans++;
            }
        }
        return ans;
    }
}
