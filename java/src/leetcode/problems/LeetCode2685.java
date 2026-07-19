package leetcode.problems;


import knowledge.datastructure.adv.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:27
 * 完全连通分量的性质：E=V×(V−1)/2;
 */
public class LeetCode2685 {

    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        // 连通分量点个数
        Map<Integer, Integer> pointCnt = new HashMap<>();
        // 连通分量【实际边个数】
        Map<Integer, Integer> edgeCnt = new HashMap<>();
        // 1. 统计点数
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            pointCnt.put(parent, pointCnt.getOrDefault(parent, 0) + 1);
        }
        // 2. 统计边数
        for (int[] edge : edges) {
            int parent = uf.find(edge[0]); // 这条边属于哪个连通分量
            edgeCnt.put(parent, edgeCnt.getOrDefault(parent, 0) + 1); // 实际边数 +1
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : pointCnt.entrySet()) {
            int v = entry.getValue();
            int expectedEdges = v * (v - 1) / 2;
            if (expectedEdges == edgeCnt.getOrDefault(entry.getKey(), 0)) {
                ans++;
            }
        }
        return ans;
    }
}
