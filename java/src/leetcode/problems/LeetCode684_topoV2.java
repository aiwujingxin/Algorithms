package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:48
 */
public class LeetCode684_topoV2 {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] degree = new int[n + 1];

        //Construct edges into adjacency list
        List<Integer>[] nexts = new List[n + 1];
        for (int i = 0; i < nexts.length; i++) {
            nexts[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            nexts[edges[i][0]].add(edges[i][1]);
            nexts[edges[i][1]].add(edges[i][0]);
        }

        //Push nodes with degree of 1 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        //Topological sort
        while (!q.isEmpty()) {

            int curNode = q.poll();

            for (Integer next : nexts[curNode]) {
                if (degree[next] == 1) {
                    continue;
                }
                degree[next]--;
                if (degree[next] == 1) {
                    q.add(next);
                }
            }
        }

        //Find the answer from the back
        for (int i = n - 1; i >= 0; i--) {
            if (degree[edges[i][0]] > 1 && degree[edges[i][1]] > 1) {
                return edges[i];
            }
        }
        return new int[]{};
    }
}
