package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 11:13
 */
public class LeetCode1334_Dijkstra {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }

        int min = Integer.MAX_VALUE;
        int res = -1;

        for (int i = 0; i < n; i++) {
            Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            boolean[] visited = new boolean[n];
            int count = 0;
            pq.add(new int[]{i, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int curNode = cur[0];
                int curDist = cur[1];

                if (visited[curNode]) {
                    continue;
                }

                visited[curNode] = true;

                count++;

                for (int adj : graph.get(curNode).keySet()) {
                    if (!visited[adj] && curDist + graph.get(curNode).get(adj) <= distanceThreshold) {
                        pq.add(new int[]{adj, curDist + graph.get(curNode).get(adj)});
                    }
                }
            }

            if (count - 1 <= min) {
                min = count - 1;
                res = i;
            }
        }

        return res;
    }
}
