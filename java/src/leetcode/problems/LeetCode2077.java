package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 16:49
 */
public class LeetCode2077 {

    public int numberOfPaths(int n, int[][] corridors) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] corridor : corridors) {
            int i = corridor[0];
            int j = corridor[1];
            graph.computeIfAbsent(i, k -> new HashSet<>()).add(j);
            graph.computeIfAbsent(j, k -> new HashSet<>()).add(i);
        }
        int count = 0;
        for (int[] corridor : corridors) {
            for (int neighbor : graph.get(corridor[0])) {
                if (graph.get(corridor[1]).contains(neighbor)) {
                    count++;
                }
            }
        }
        return count / 3;
    }
}
