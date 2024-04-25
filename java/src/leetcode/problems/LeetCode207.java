package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 14:35
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        int cnt = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                visited[i] = true;
                cnt++;
            }
        }
        if (cnt == 0) {
            return false;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0 && !visited[next]) {
                    queue.add(next);
                    cnt++;
                    visited[next] = true;
                }
            }
        }
        return cnt == numCourses;
    }
}
