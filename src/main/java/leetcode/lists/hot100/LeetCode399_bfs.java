package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 17:46
 */
public class LeetCode399_bfs {

    //https://leetcode.com/problems/evaluate-division/discuss/2380908/4-Approaches%3A-BFS-DFS-Floyd-Union-Find

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        Map<String, Integer> varMap = new HashMap<>();
        int varCnt = 0;
        for (List<String> equation : equations) {
            if (!varMap.containsKey(equation.get(0))) {
                varMap.put(equation.get(0), varCnt++);
            }
            if (!varMap.containsKey(equation.get(1))) {
                varMap.put(equation.get(1), varCnt++);
            }
        }

        List<Pair>[] edges = new List[varCnt];
        for (int i = 0; i < varCnt; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            int va = varMap.get(equations.get(i).get(0));
            int vb = varMap.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCnt = queries.size();
        double[] ans = new double[queriesCnt];
        for (int i = 0; i < queriesCnt; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (varMap.containsKey(query.get(0)) && varMap.containsKey(query.get(1))) {
                int idxA = varMap.get(query.get(0));
                int idxB = varMap.get(query.get(1));
                if (idxA == idxB) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(idxA);
                    double[] ratios = new double[varCnt];
                    Arrays.fill(ratios, -1.0);
                    ratios[idxA] = 1.0;
                    while (!points.isEmpty() && ratios[idxB] < 0) {
                        int cur = points.poll();
                        for (Pair pair : edges[cur]) {
                            int y = pair.index;
                            double value = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[cur] * value;
                                points.offer(y);
                            }
                        }
                    }

                    result = ratios[idxB];
                }
            }

            ans[i] = result;
        }

        return ans;
    }

    static class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
