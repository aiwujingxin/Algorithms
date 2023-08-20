package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/27 19:30
 */
public class LeetCode787_dfs_TEL {

    int ans_dfs;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ans_dfs = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] i : flights) {
            map.putIfAbsent(i[0], new ArrayList<>());
            map.get(i[0]).add(new int[]{i[1], i[2]});
        }
        dfs(map, src, dst, K + 1, 0);
        return ans_dfs == Integer.MAX_VALUE ? -1 : ans_dfs;
    }

    public void dfs(Map<Integer, List<int[]>> map, int src, int dst, int k, int cost) {
        if (k < 0)
            return;
        if (src == dst) {
            ans_dfs = cost;
            return;
        }
        if (!map.containsKey(src))
            return;
        for (int[] i : map.get(src)) {
            if (cost + i[1] > ans_dfs) {               //Pruning, check the sum of current price and next cost. If it's greater then the ans so far, continue
                continue;
            }
            dfs(map, i[0], dst, k - 1, cost + i[1]);
        }
    }
}
