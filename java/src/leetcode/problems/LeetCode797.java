package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 14:10
 */
public class LeetCode797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return new ArrayList<>();
        }
        // build graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());

        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backtrack(0, list, map, temp, graph.length);
        return list;
    }

    private void backtrack(Integer start, List<List<Integer>> list, Map<Integer, List<Integer>> map, List<Integer> temp, int n) {
        if (start == n - 1) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int j = 0; j < map.get(start).size(); j++) {
            temp.add(map.get(start).get(j));
            backtrack(map.get(start).get(j), list, map, temp, n);
            temp.remove(temp.size() - 1);
        }
    }
}
