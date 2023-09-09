package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:10
 */
public class LeetCode785_bfs {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

