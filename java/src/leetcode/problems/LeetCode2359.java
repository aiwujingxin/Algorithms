package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/7 22:51
 */
public class LeetCode2359 {

    List<Integer>[] graph;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            graph[i].add(edges[i]);
        }
        int[] d1 = new int[n];
        Arrays.fill(d1, -1);
        int[] d2 = new int[n];
        Arrays.fill(d2, -1);
        bfs(d1, node1);
        bfs(d2, node2);
        int d = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (d1[i] == -1 || d2[i] == -1)
                continue;
            int t = Math.max(d1[i], d2[i]);
            if (t < d) {
                res = i;
                d = t;
            }
        }
        return res;
    }

    public void bfs(int[] d, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                d[cur] = step;
                for (int ch : graph[cur]) {
                    if (ch != -1 && d[ch] == -1) {
                        q.add(ch);
                    }
                }
            }
            step++;
        }
    }
}
