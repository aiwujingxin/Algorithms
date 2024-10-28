package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:27
 */
public class LeetCode210 {

    public int[] findOrder(int n, int[][] prerequisites) {
        int[] order = new int[n];
        int[] degree = new int[n];
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            degree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                order[cnt] = i;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;
            for (int next : graph[cur]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                    order[cnt] = next;
                }
            }
        }
        return cnt == n ? order : new int[]{};
    }
}
