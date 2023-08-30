package leetcode;

import basicKnowledge.dataStructure.graph.detectcycle.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 16:03
 */
public class LeetCode1059_bfs_WA {


    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        DetectCycle_bfs d = new DetectCycle_bfs();
        if (d.hasCycle(n, edges)) {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (map.get(node).isEmpty()) {
                if (node != destination) {
                    return false;
                }
            }
            for (int next : map.get(node)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
            }
        }
        return true;
    }


}
