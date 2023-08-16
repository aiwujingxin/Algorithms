package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/21 22:24
 */

//https://leetcode.cn/problems/cheapest-flights-within-k-stops/solution/tong-ge-lai-shua-ti-la-yi-ti-si-jie-bfs-deqpt/
public class LeetCode787_bfs_v2 {

    int INF = 1000007;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return bfs(n, flights, src, dst, k);
    }

    private int bfs(int n, int[][] flights, int src, int dst, int k) {
        // 整理题目给定的flights，转换成每个节点的子节点有哪些
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            g[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        // 表示src到i到最小价格
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        // 退出条件加上 k 的限制
        while (!queue.isEmpty() && k + 1 > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]]) {
                    int distance = poll[1] + path[1];
                    // 剪枝1，小于 i 之前记录的最小值，且小于 dst 之前记录的最小值
                    if (distance < ans[path[0]] && distance < ans[dst]) {
                        ans[path[0]] = distance;
                        // 剪枝2，到 dst 了就不用继续往下了
                        if (path[0] != dst) {
                            queue.offer(new int[]{path[0], distance});
                        }
                    }
                }
            }
            k--;
        }

        return ans[dst] >= INF ? -1 : ans[dst];
    }
}
