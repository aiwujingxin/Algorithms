package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:27
 */
public class LeetCode210 {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            graph[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                res[cnt] = i;
                cnt++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    res[cnt] = next;
                    cnt++;
                }
            }
        }
        return cnt == numCourses ? res : new int[]{};
    }
}
