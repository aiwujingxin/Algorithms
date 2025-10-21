package leetcode.lists.lcr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 18:39
 */
public class LCR111 {

    Map<String, Map<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            graph.putIfAbsent(equation.get(0), new HashMap<>());
            graph.get(equation.get(0)).put(equation.get(1), values[i]);
            graph.putIfAbsent(equation.get(1), new HashMap<>());
            graph.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String target, HashSet<String> visited) {
        if (!graph.containsKey(start)) {
            return -1;
        }
        if (graph.get(start).containsKey(target)) {
            return graph.get(start).get(target);
        }
        visited.add(start);
        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            double value = dfs(entry.getKey(), target, visited);
            if (value != -1) {
                return value * entry.getValue();
            }
        }
        return -1;
    }
}
