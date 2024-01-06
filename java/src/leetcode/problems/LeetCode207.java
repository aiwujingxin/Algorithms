package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:00
 * @description 拓扑排序
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
                cnt++;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                    cnt++;
                }
            }
        }
        return cnt == numCourses;
    }
}
