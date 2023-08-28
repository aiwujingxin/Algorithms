package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 23:34
 * <a href="https://leetcode.com/problems/possible-bipartition/discuss/593828/java-DFSBFS-3-clean-simple-approaches-intuitive-%2B-unusual-better-than-most-voted">...</a>
 * @see LeetCode785_bfs
 */
public class LeetCode886_bfs {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // build tree
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int u = dislike[0] - 1;
            int v = dislike[1] - 1;
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }

            colors[i] = 1;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int adj : map.get(node)) {
                    if (colors[adj] == colors[node]) {
                        return false;
                    }

                    if (colors[adj] == 0) {
                        colors[adj] = -colors[node];
                        queue.add(adj);
                    }
                }
            }
        }

        return true;
    }
}

