package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 16:01
 */
public class LeetCode261 {

    public static void main(String[] args) {
        System.out.println(new LeetCode261().validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer next : map.get(node)) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        return set.size() == n;
    }
}
