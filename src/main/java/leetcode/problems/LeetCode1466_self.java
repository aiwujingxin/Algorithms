package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 12:45
 */
public class LeetCode1466_self {

    public static void main(String[] args) {
        System.out.println(new LeetCode1466_self().minReorder(3, new int[][]{{1, 2}, {2, 0}}));
    }

    int count = 0;

    public int minReorder(int n, int[][] connections) {

        // build graph
        Map<Integer, List<Integer>> out = new HashMap<>();
        Map<Integer, List<Integer>> in = new HashMap<>();
        for (int[] connection : connections) {
            out.putIfAbsent(connection[0], new ArrayList<>());
            out.get(connection[0]).add(connection[1]);

            in.putIfAbsent(connection[1], new ArrayList<>());
            in.get(connection[1]).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(0, out, in, visited);
        return count;
    }

    private void dfs(int start, Map<Integer, List<Integer>> out, Map<Integer, List<Integer>> in, boolean[] visited) {
        visited[start] = true;

        if (out.containsKey(start)) {
            for (Integer i : out.get(start)) {
                if (visited[i]) {
                    continue;
                }
                count++;
                dfs(i, out, in, visited);
            }
        }

        if (in.containsKey(start)) {
            for (Integer i : in.get(start)) {
                if (visited[i]) {
                    continue;
                }
                dfs(i, out, in, visited);
            }
        }

    }
}
