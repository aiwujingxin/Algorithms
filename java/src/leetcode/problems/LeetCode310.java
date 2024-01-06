package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/6 13:26
 * @description 无向图 拓扑排序
 */
public class LeetCode310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);

                for (int next : graph[cur]) {
                    degree[next]--;
                    if (degree[next] == 1) {
                        queue.add(next);
                    }
                }
            }

        }
        return res;
    }
}
