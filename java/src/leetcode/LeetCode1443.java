package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:13
 */
public class LeetCode1443 {


    HashMap<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited;
    List<Boolean> hasApple;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        this.hasApple = hasApple;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        return Math.max(dfsMinTime(0) - 2, 0);
    }

    public int dfsMinTime(int cur) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        int res = 0;
        for (Integer next : map.get(cur)) {
            res += dfsMinTime(next);
        }
        if (res != 0) {
            return 2 + res;
        }
        return hasApple.get(cur) ? 2 : 0;
    }
}
