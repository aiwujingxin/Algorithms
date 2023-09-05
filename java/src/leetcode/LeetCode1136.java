package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/5 17:13
 */
public class LeetCode1136 {

    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adj = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }
        HashSet<Integer> set = new HashSet<>();
        int[] indegree = new int[n + 1];
        for (int[] v : relations) {
            adj[v[0]].add(v[1]);
            indegree[v[1]]++;
        }
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int semester = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                cnt++;
                for (int next : adj[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            semester++;
        }
        return cnt == n ? semester : -1;
    }
}
