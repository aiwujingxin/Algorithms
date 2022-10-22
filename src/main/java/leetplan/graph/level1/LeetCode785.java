package leetplan.graph.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 22:56
 * <a href="https://leetcode.com/problems/is-graph-bipartite/discuss/2719420/Java-DFS-and-BFS-Solution-Easy-Clean-Code-with-Comments">...</a>
 */
public class LeetCode785 {

    //Bipartite graph 可以被红绿两种颜色染色
    //且相邻顶点之间不能染相同的颜色
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!isbfs(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isbfs(int[][] graph, int i, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (int next : graph[node]) {
                if (color[next] == -1) {
                    q.add(next);
                    color[next] = 1 - color[node];
                    //再次相等的时候
                    //1 - (1 - color[node]) = color[node]
                    //意思是, 要么等于 -1 要么 等于 0 ,要么等于 color[node]
                } else {

                    if (color[next] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
