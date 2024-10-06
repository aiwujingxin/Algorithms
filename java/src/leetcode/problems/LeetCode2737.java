package leetcode.problems;


import knowledge.datastructure.graph.shortestpath.Dijkstra;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 17:28
 */
public class LeetCode2737 {

    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        int[][] es = new int[edges.size()][3];
        for (int i = 0; i < edges.size(); i++) {
            es[i] = new int[]{edges.get(i).get(0), edges.get(i).get(1), edges.get(i).get(2)};
        }
        int[] dist = new Dijkstra().shortestPath(n, es, s);
        int ans = 0x3f3f3f3f;
        Set<Integer> set = new HashSet<>();
        for (int j : marked) {
            set.add(j);
        }
        for (int i = 0; i < dist.length; i++) {
            if (i == s || !set.contains(i)) {
                continue;
            }
            ans = Math.min(ans, dist[i]);
        }
        return ans == 0x3f3f3f3f ? -1 : ans;
    }
}
