package leetcode;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:16
 */
public class LeetCode518_dfs {

    //https://leetcode.com/problems/coin-change-ii/discuss/1549630/Java-or-TC%3A-O(C*A)-or-SC%3A-O(A)-or-DP-(Botton-Up-and-Top-Down-approaches)
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        return dfs(amount, coins, coins.length - 1, map);
    }

    private int dfs(int amount, int[] coins, int idx, HashMap<Integer, HashMap<Integer, Integer>> map) {
        if (amount < 0 || idx < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (map.containsKey(idx) && map.get(idx).containsKey(amount)) {
            return map.get(idx).get(amount);
        }

        int count = dfs(amount - coins[idx], coins, idx, map) + dfs(amount, coins, idx - 1, map);
        map.putIfAbsent(idx, new HashMap<>());
        map.get(idx).put(amount, count);
        return count;
    }
}
