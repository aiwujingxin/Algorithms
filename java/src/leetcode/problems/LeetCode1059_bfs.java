package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 18:08
 */
public class LeetCode1059_bfs {

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if (source == destination && edges.length < 1) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        if (graph.get(source).isEmpty() || !graph.get(destination).isEmpty()) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] passed = new boolean[n];
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (passed[node]) continue;
            passed[node] = true;
            for (int next : graph.get(node)) {
                // 已经是末节点，检查是不是目标
                if (graph.get(next).isEmpty() && next != destination) {
                    return false;
                }
                // 发现曾经用过，重点检查是否存在环
                if (passed[next] && hasCycle(graph, next)) {
                    return false;
                }
                if (!passed[next]) queue.add(next);
            }
        }
        return true;
    }

    // 是否存在环
    private boolean hasCycle(Map<Integer, Set<Integer>> graph, int node) {
        if (graph.get(node).isEmpty()) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            for (int next : graph.get(queue.poll())) {
                if (next == node) {
                    return true;
                }
                queue.add(next);
            }
        }
        return false;
    }
}
