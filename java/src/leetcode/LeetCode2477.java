package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 14:27
 */
public class LeetCode2477 {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    long res;
    int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads == null || roads.length == 0) {
            return 0;
        }
        this.seats = seats;
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        dfs(0, -1);
        return res;
    }

    private int dfs(int x, int fa) {
        int size = 1;
        for (int y : map.get(x)) {
            if (y != fa) {
                size += dfs(y, x);
            }
        }
        if (x != 0) {
            res += (size + seats - 1) / seats;
        }
        return size;
    }
}
