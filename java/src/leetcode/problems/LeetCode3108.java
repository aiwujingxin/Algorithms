package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/10/25 13:38
 */
public class LeetCode3108 {
    static class Node {
        int node;
        int andValue;

        public Node(int node, int andValue) {
            this.node = node;
            this.andValue = andValue;
        }
    }

    HashMap<Integer, Integer> groupMap; // node -> group
    HashMap<Integer, Integer> groupMinAnd; // group -> 最小AND值（所有边权的AND）
    HashSet<Integer> visited;
    List<int[]>[] graph;
    int group = 0;

    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        // 初始化数据结构
        groupMap = new HashMap<>();
        groupMinAnd = new HashMap<>();
        visited = new HashSet<>();

        // 构建带权图
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        // 处理每个连通分量
        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) continue;

            // 使用BFS遍历连通分量，并计算所有边权的AND
            int minAnd = (1 << 30) - 1; // 初始全1
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited.add(i);
            groupMap.put(i, group);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int[] neighbor : graph[current]) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    // 累积所有边权的AND
                    minAnd &= weight;
                    if (!visited.contains(nextNode)) {
                        visited.add(nextNode);
                        groupMap.put(nextNode, group);
                        queue.add(nextNode);
                    }
                }
            }
            groupMinAnd.put(group, minAnd);
            group++;
        }

        // 处理查询
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0], t = queries[i][1];
            if (!groupMap.containsKey(s) || !groupMap.containsKey(t) || !groupMap.get(s).equals(groupMap.get(t))) {
                answer[i] = -1;
            } else {
                int groupId = groupMap.get(s);
                answer[i] = groupMinAnd.get(groupId);
            }
        }
        return answer;
    }
}
