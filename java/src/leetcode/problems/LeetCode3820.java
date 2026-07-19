package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 6/2/26 23:01
 */
public class LeetCode3820 {
    List<Integer>[] graph;

    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int cnt = 0;
        int[][] arr = new int[n][3];
        int[] nodes = new int[]{x, y, z};
        for (int i = 0; i < nodes.length; i++) {
            check(nodes[i], i, x, y, z, arr);
        }
        for (int i = 0; i < n; i++) {
            int[] f = new int[]{arr[i][0], arr[i][1], arr[i][2]};
            Arrays.sort(f);
            if (f[0] * f[0] + f[1] * f[1] == f[2] * f[2]) {
                cnt++;
            }
        }
        return cnt;
    }

    private void check(int root, int index, int x, int y, int z, int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        vis.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                arr[index][node] = step;
                for (int nx : graph[node]) {
                    if (vis.contains(nx)) {
                        continue;
                    }
                    vis.add(nx);
                    queue.add(nx);
                }
            }
            step++;
        }
    }
}
