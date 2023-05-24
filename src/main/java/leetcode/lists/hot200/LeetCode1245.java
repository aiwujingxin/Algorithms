package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:38
 */
public class LeetCode1245 {

    int res = 0;

    public int treeDiameter(int[][] edges) {
        List<Integer>[] map = new ArrayList[edges.length + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        dfs(map, 0, new boolean[edges.length + 1]);
        return res;
    }

    public int dfs(List<Integer>[] map, int index, boolean[] visited) {
        visited[index] = true;
        int maxLen = 0;
        for (int next : map[index]) {
            if (!visited[next]) {
                int len = dfs(map, next, visited);
                res = Math.max(res, maxLen + len);
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen + 1;
    }
}
