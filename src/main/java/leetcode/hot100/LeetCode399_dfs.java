package leetcode.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 17:47
 */
public class LeetCode399_dfs {

    //https://leetcode.com/problems/evaluate-division/discuss/2043629/Java-Union-Find-or-BFS-or-DFS

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = toAdj(equations, values);

        int querySize = queries.size();
        double[] res = new double[querySize];
        for (int i = 0; i < querySize; i++) {
            Set<String> visited = new HashSet<>();
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            res[i] = dfs(adj, visited, start, target);
        }

        return res;
    }

    public Map<String, Map<String, Double>> toAdj(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            adj.putIfAbsent(u, new HashMap<>());
            adj.get(u).put(v, values[i]);
            adj.putIfAbsent(v, new HashMap<>());
            adj.get(v).put(u, 1 / values[i]);
        }
        return adj;
    }


    public Double dfs(Map<String, Map<String, Double>> adj, Set<String> visited, String curr, String target) {
        if (!adj.containsKey(curr)) {
            return -1.0;
        }
        if (adj.get(curr).containsKey(target)) {
            return adj.get(curr).get(target);
        }
        visited.add(curr);
        Map<String, Double> edges = adj.get(curr);
        for (Map.Entry<String, Double> entry : edges.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                Double weight = dfs(adj, visited, entry.getKey(), target);
                if (weight != -1.0) {
                    return entry.getValue() * weight;
                }
            }
        }
        return -1.0;
    }
}
