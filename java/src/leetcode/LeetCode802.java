package leetcode;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 23:56
 */
public class LeetCode802 {

    //https://leetcode.cn/problems/find-eventual-safe-states/solutions/916564/gtalgorithm-san-ju-hua-jiao-ni-wan-zhuan-xf5o/
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 反图，邻接表存储
        List<List<Integer>> newGraph = new ArrayList<>(n);
        // 节点入度
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            newGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int x : graph[i]) {
                newGraph.get(x).add(i);
            }
            // 原数组记录的节点出度，在反图中就是入度
            inDegree[i] = graph[i].length;
        }

        // 拓扑排序
        Queue<Integer> queue = new LinkedList<>();

        // 首先将入度为 0 的点存入队列
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            // 每次弹出队头元素
            int cur = queue.poll();

            for (int next : newGraph.get(cur)) {
                // 将以其为起点的有向边删除，更新终点入度
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 最终入度（原图中出度）为 0 的所有点均为安全点
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
