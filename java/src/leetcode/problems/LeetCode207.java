package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 19:40
 */
public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int n = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            n++;
            for (int next : graph[cur]) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return n == numCourses;
    }
}
