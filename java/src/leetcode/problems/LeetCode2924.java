package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 19:11
 */
public class LeetCode2924 {

    public int findChampion(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            graph[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int res = -1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph[node].isEmpty()) {
                if (res == -1) {
                    res = node;
                } else {
                    if (res != node) {
                        return -1;
                    }
                }
            } else {
                for (int next : graph[node]) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return res;
    }
}
