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
        //fix case
        //5
        //[[0,1],[1,2],[2,3],[1,3],[1,4]]
//        if (edges.length != n - 1) {
//            return false;
//        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> one = map.getOrDefault(edge[0], new ArrayList<>());
            one.add(edge[1]);
            map.put(edge[0], one);
            List<Integer> two = map.getOrDefault(edge[1], new ArrayList<>());
            one.add(edge[0]);
            map.put(edge[1], two);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> nebers = map.getOrDefault(node, new ArrayList<>());
            for (Integer next : nebers) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        System.out.println(set);
        return set.size() == n;
    }
}
