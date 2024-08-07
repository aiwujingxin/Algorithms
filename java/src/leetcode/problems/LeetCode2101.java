package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 17:11
 */
public class LeetCode2101 {

    int[][] bombs;

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        this.bombs = bombs;
        for (int[] bomb : bombs) {
            int res = bfs(bomb);
            max = Math.max(max, res);
        }
        return max;
    }

    private int bfs(int[] start) {

        Queue<int[]> queue = new LinkedList<>();
        HashSet<int[]> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            List<int[]> nexts = getNexts(node, set);
            for (int[] next : nexts) {
                if (set.contains(next)) {
                    continue;
                }
                set.add(next);
                queue.add(next);
            }
        }

        return set.size();
    }

    private List<int[]> getNexts(int[] node, HashSet<int[]> set) {
        List<int[]> list = new ArrayList<>();
        for (int[] b : this.bombs) {
            if (set.contains(b)) {
                continue;
            }
            double len = Math.sqrt((long) (node[0] - b[0]) * (node[0] - b[0]) + (long) (node[1] - b[1]) * (node[1] - b[1]));
            double r = node[2];
            if (len <= r) {
                list.add(b);
            }
        }
        return list;
    }
}
