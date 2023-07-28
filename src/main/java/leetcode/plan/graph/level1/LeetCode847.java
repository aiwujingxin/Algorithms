package leetcode.plan.graph.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 23:23
 */
public class LeetCode847 {

    //https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/1800328/JAVA-or-BFS-or-With-comments-or-Clean-code

    static class Node {
        int visited;
        int dist;
        int node;

        Node(int node, int dist, int visited) {
            this.node = node;
            this.dist = dist;
            this.visited = visited;
        }
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        // This is to eliminate repetitive steps
        Set<Integer>[] visited = new HashSet[n];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = new HashSet<>();
            queue.add(new Node(i, 0, 1 << i));
            visited[i].add(1 << i);
        }
        // BFS
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.visited == (1 << n) - 1) {
                return node.dist;
            }
            for (int nei : graph[node.node]) {
                int mask = node.visited | (1 << nei);
                if (visited[nei].add(mask)) {
                    queue.add(new Node(nei, 1 + node.dist, mask));
                }
            }
        }
        return -1;
    }
}
