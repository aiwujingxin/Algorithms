package leetplan.graph.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 18:24
 */
public class LeetCode1091 {


    public static void main(String[] args) {
        System.out.println(new LeetCode1091().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0][0] == 1) {
            return -1;
        }
        if (grid.length == 1 && grid[0].length == 1) {
            return grid[0][0] == 0 ? 1 : -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(new int[]{0, 0, 1});
        set.add("0" + "," + "0");
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            List<int[]> next = getNext(node, grid, set, node[2]);
            for (int[] n : next) {
                queue.add(new int[]{n[0], n[1], n[2]});
                set.add(n[0] + "," + n[1]);
                if (n[0] == grid.length - 1 && n[1] == grid[0].length - 1) {
                    res = Math.min(n[2], res);
                }
            }
        }
        if (!set.contains((grid.length - 1) + "," + (grid[0].length - 1))) {
            return -1;
        }
        return res;
    }

    int[][] dis = new int[][]{{1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}};

    private List<int[]> getNext(int[] node, int[][] grid, HashSet<String> set, int step) {
        List<int[]> list = new ArrayList<>();
        for (int[] di : dis) {
            int x = node[0] + di[0];
            int y = node[1] + di[1];
            if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 ||
                    grid[x][y] != 0 || set.contains(x + "," + y)) {
                continue;
            }

            list.add(new int[]{x, y, step + 1});
        }
        return list;
    }
}
