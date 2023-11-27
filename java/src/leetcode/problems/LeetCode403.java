package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 20:41
 */
public class LeetCode403 {

    Map<Integer, Integer> map = new HashMap<>();
    // int[][] cache = new int[2009][2009];
    Map<String, Boolean> cache = new HashMap<>();

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }
        if (!map.containsKey(1)) {
            return false;
        }
        return dfs(stones, stones.length, 1, 1);
    }

    boolean dfs(int[] stones, int n, int u, int k) {
        String key = u + "_" + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (u == n - 1) {
            return true;
        }
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) {
                continue;
            }
            int next = stones[u] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + i);
                cache.put(key, cur);
                if (cur) {
                    return true;
                }
            }
        }
        cache.put(key, false);
        return false;
    }
}
