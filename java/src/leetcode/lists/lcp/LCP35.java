package leetcode.lists.lcp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 17:03
 */
public class LCP35 {

    final int INF = Integer.MAX_VALUE / 2; // 防止溢出

    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        // 邻接表建图
        List<List<int[]>> graph = new ArrayList<>();
        int n = charge.length;
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] path : paths) {
            int u = path[0], v = path[1], w = path[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }
        // (位置，电量)
        int[][] distance = new int[n][cnt + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= cnt; j++) {
                distance[i][j] = INF;
            }
        }
        // (位置，电量)
        boolean[][] visited = new boolean[n][cnt + 1];
        // 0 当前点
        // 1 当前电量
        // 2 当前时间
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.add(new int[]{start, 0, 0});
        while (!heap.isEmpty()) {
            int[] record = heap.poll();
            int u = record[0], power = record[1], time = record[2];
            if (visited[u][power]) {
                continue;
            }
            // 如果到end，直接返回
            if (u == end) {
                return time;
            }
            visited[u][power] = true;
            if (power < cnt) {
                // 充一格电
                if (!visited[u][power + 1] && time + charge[u] < distance[u][power + 1]) {
                    distance[u][power + 1] = time + charge[u];
                    heap.add(new int[]{u, power + 1, time + charge[u]});
                }
            }
            // 不充电，直接去往下一个城市
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                int nextPower = power - w;
                int nextTime = time + w;
                if (nextPower >= 0 && !visited[v][nextPower] && nextTime < distance[v][nextPower]) {
                    distance[v][nextPower] = nextTime;
                    heap.add(new int[]{v, nextPower, nextTime});
                }
            }
        }
        return -1;
    }
}
