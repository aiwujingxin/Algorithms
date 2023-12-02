package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 20:41
 * @description 递归会有重复状态
 */
public class LeetCode403 {

    Map<Integer, Integer> map = new HashMap<>();
    Map<String, Boolean> memo = new HashMap<>();

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

    boolean dfs(int[] stones, int n, int index, int k) {
        String key = index + "_" + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (index == n - 1) {
            return true;
        }
        // choice
        for (int i = -1; i <= 1; i++) {
            if (k + i == 0) {
                continue;
            }
            int next = stones[index] + k + i;
            if (map.containsKey(next)) {
                boolean cur = dfs(stones, n, map.get(next), k + i);
                memo.put(key, cur);
                if (cur) {
                    return true;
                }
            }
        }
        memo.put(key, false);
        return false;
    }
}
