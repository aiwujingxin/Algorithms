package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/27 19:35
 */
public class LeetCode787_bfs {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] i : flights) {
            map.putIfAbsent(i[0], new ArrayList<>());
            map.get(i[0]).add(new int[]{i[1], i[2]});
        }
        int step = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == dst) {
                    ans = Math.min(ans, curr[1]);
                }
                if (!map.containsKey(curr[0])) {
                    continue;
                }
                for (int[] f : map.get(curr[0])) {
                    if (curr[1] + f[1] > ans) { // 剪枝
                        continue;
                    }

                    q.offer(new int[]{f[0], curr[1] + f[1]});
                }
            }
            if (step++ > K) {
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
