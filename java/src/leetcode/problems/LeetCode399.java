package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 21:58
 */
public class LeetCode399 {

    //https://leetcode.com/problems/evaluate-division/discuss/2043629/Java-Union-Find-or-BFS-or-DFS

    //https://www.youtube.com/watch?v=berj4Xm_YTY
    HashMap<String, Map<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, w);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / w);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            HashSet<String> visited = new HashSet<>();
            res[i] = dfs(visited, queries.get(i).get(0), queries.get(i).get(1));
        }
        return res;
    }

    private double dfs(HashSet<String> visited, String start, String end) {
        if (!graph.containsKey(start)) {
            return -1;
        }
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (Map.Entry<String, Double> next : graph.get(start).entrySet()) {
            if (visited.contains(next.getKey())) {
                continue;
            }
            double res = dfs(visited, next.getKey(), end);
            if (res != -1) {
                return res * next.getValue();
            }
        }
        return -1;
    }
}
