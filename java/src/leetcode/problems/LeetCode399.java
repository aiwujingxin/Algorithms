package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 21:58
 * @link <a href="https://leetcode.com/problems/evaluate-division/discuss/2043629/Java-Union-Find-or-BFS-or-DFS">UF</a>
 */
public class LeetCode399 {

    HashMap<String, HashMap<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            HashMap<String, Double> map1 = graph.getOrDefault(equation.get(0), new HashMap<>());
            map1.put(equation.get(1), values[i]);
            graph.put(equation.get(0), map1);
            HashMap<String, Double> map2 = graph.getOrDefault(equation.get(1), new HashMap<>());
            map2.put(equation.get(0), 1 / values[i]);
            graph.put(equation.get(1), map2);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return res;
    }

    public double dfs(String start, String end, HashSet<String> set) {
        if (graph.get(start) == null || set.contains(start)) {
            return -1;
        }
        set.add(start);
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        for (Map.Entry<String, Double> next : graph.get(start).entrySet()) {
            double t = dfs(next.getKey(), end, set);
            if (t != -1) {
                return graph.get(start).get(next.getKey()) * t;
            }
        }
        return -1;
    }
}
