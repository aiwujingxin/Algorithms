package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 23:36
 * @see LeetCode1443
 */
public class LeetCode1376 {

    int[] manager;
    int[] informTime;

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.manager = manager;
        this.informTime = informTime;
        build(n);
        return dfs(headID);
    }

    private void build(int n) {
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
    }

    private int dfs(int cur) {

        int res = 0;

        List<Integer> list = map.get(cur);
        if (list == null) {
            return 0;
        }
        for (Integer next : list) {
            res = Math.max(res, dfs(next));
        }
        return res + informTime[cur];
    }

}
