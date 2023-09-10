package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/21 21:51
 */
public class LeetCode1462_topo {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new List[n];
        boolean[][] prerequisitesMatrix = new boolean[n][n];
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]].add(prerequisite[1]);
            indegrees[prerequisite[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                prerequisitesMatrix[curr][next] = true;
                for (int i = 0; i < n; i++) {
                    if (prerequisitesMatrix[i][curr]) {
                        prerequisitesMatrix[i][next] = true;
                    }
                }
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(prerequisitesMatrix[query[0]][query[1]]);
        }
        return answer;
    }
}
