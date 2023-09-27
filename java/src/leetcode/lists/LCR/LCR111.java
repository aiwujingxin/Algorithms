package leetcode.lists.LCR;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 18:39
 */
public class LCR111 {

    Map<String, Map<String, Double>> gragh;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        gragh = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            gragh.putIfAbsent(equation.get(0), new HashMap<>());
            gragh.get(equation.get(0)).put(equation.get(1), values[i]);
            gragh.putIfAbsent(equation.get(1), new HashMap<>());
            gragh.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String target, HashSet<String> visited) {
        if (!gragh.containsKey(start)) {
            return -1;
        }
        if (gragh.get(start).containsKey(target)) {
            return gragh.get(start).get(target);
        }
        visited.add(start);
        for (Map.Entry<String, Double> entry : gragh.get(start).entrySet()) {
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
