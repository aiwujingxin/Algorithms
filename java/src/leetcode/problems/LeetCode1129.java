package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/23 17:43
 */
public class LeetCode1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : redEdges) {
            graph[edge[0]].add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new int[]{edge[1], 1});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        visited[0][1] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            int prevColor = curr[2];
            for (int[] edge : graph[node]) {
                int nextNode = edge[0];
                int edgeColor = edge[1];
                if (edgeColor == prevColor) {
                    continue;
                }
                if (visited[nextNode][edgeColor]) {
                    continue;
                }
                ans[nextNode] = Math.min(ans[nextNode], dist + 1);
                visited[nextNode][edgeColor] = true;
                queue.offer(new int[]{nextNode, dist + 1, edgeColor});
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
