package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/8 12:59
 */
public class LeetCode2400 {

    Map<Integer, Map<Integer, Integer>> memo;
    int endPos;

    public int numberOfWays(int startPos, int endPos, int k) {
        memo = new HashMap<>();
        // 初始化
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        memo.put(startPos, map);
        this.endPos = endPos;
        return dfs(startPos, k);
    }

    private int dfs(int cur, int k) {
        // 退出条件
        if (Math.abs(cur - endPos) > k) {
            return 0;
        }
        if (k == 0) {
            return cur == endPos ? 1 : 0;
        }
        if (memo.containsKey(cur) && memo.get(cur).containsKey(k)) {
            return memo.get(cur).get(k);
        }
        int res = (dfs(cur - 1, k--) + dfs(cur + 1, k--)) % 10000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(k, res);
        memo.put(cur, map);
        return res;
    }
}
