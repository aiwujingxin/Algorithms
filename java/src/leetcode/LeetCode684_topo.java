package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:46
 */
public class LeetCode684_topo {
    public int[] findRedundantConnection(int[][] edges) {
        var n = edges.length;
        var adjList = new HashMap<Integer, Set<Integer>>();
        var inDegree = new HashMap<Integer, Integer>();
        var q = new LinkedList<Integer>();
        populate(n, edges, adjList, inDegree, q);

        while (!q.isEmpty()) {
            var head = q.poll();

            for (var neighbor : adjList.get(head)) {
                inDegree.compute(neighbor, (k, v) -> v - 1);
                if (inDegree.get(neighbor) == 1)
                    q.add(neighbor);
            }

            adjList.remove(head);
        }

        for (var i = n - 1; i >= 0; i--)
            if (adjList.containsKey(edges[i][0]) && adjList.containsKey(edges[i][1]))
                return edges[i];
        return null;
    }

    private void populate(int n, int[][] edges, Map<Integer, Set<Integer>> adjList,
                          Map<Integer, Integer> inDegree, Queue<Integer> q) {
        for (var i = 1; i <= n; i++) {
            adjList.put(i, new HashSet<>());
            inDegree.put(i, 0);
        }
        for (var edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            inDegree.compute(edge[1], (k, v) -> v + 1);
            inDegree.compute(edge[0], (k, v) -> v + 1);
        }
        for (var i = 1; i <= n; i++)
            if (inDegree.get(i) == 1)
                q.add(i);
    }
}
