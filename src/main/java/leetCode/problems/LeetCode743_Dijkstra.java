package leetCode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:41
 */
public class LeetCode743_Dijkstra {

    /*本题需要用到单源最短路径算法 Dijkstra，现在让我们回顾该算法，其主要思想是贪心。

将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。

每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」。

     *
     * */

    public int networkDelayTime(int[][] times, int n, int K) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] rows : times) {
            graph[rows[0] - 1][rows[1] - 1] = rows[2];
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[K - 1] = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            //每次从「未确定节点」中取一个与起点距离最短的点
            int v = minIndex(distance, visited);
            if (v == -1) {
                continue;
            }
            visited[v] = true;
            for (int j = 0; j < n; j++) {
                if (graph[v][j] != Integer.MAX_VALUE) {
                    //「更新」从起点到其他所有「未确定节点」的距离
                    if (graph[v][j] + distance[v] < distance[j]) {
                        distance[j] = graph[v][j] + distance[v];
                    }
                }
            }
        }
        int result = 0;
        for (int dist : distance) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist);
        }
        return result;
    }

    private int minIndex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
