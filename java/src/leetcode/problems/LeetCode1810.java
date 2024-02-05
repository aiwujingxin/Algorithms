package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:48
 */
public class LeetCode1810 {

    private final int[][] grid = new int[200][200];
    private int[] target = null;
    private final char[] dire = new char[]{'U', 'D', 'L', 'R'};
    private final char[] reDire = new char[]{'D', 'U', 'R', 'L'};
    private final int[][] values = new int[][]{
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    public int findShortestPath(GridMaster master) {
        if (master.isTarget()) {
            return 0;
        }
        dfs(master, 100, 100, 0);
        if (target == null) {
            return -1;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        queue.add(new int[]{100, 100, 0});
        boolean[][] match = new boolean[200][200];
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (match[cur[0]][cur[1]]) {
                continue;
            }
            match[cur[0]][cur[1]] = true;
            if (cur[0] == target[0] && cur[1] == target[1]) {
                return cur[2];
            }
            for (int[] value : values) {
                int[] next = new int[]{value[0] + cur[0], value[1] + cur[1], 0};
                if (next[0] < 0 || next[0] >= 200 || next[1] < 0 || next[1] >= 200) {
                    continue;
                }
                if (grid[next[0]][next[1]] == 0) {
                    continue;
                }
                next[2] = cur[2] + grid[next[0]][next[1]];
                queue.add(next);
            }
        }
        return 0;
    }

    private void dfs(GridMaster master, int x, int y, int cost) {
        if (master.isTarget()) {
            grid[x][y] = cost;
            target = new int[]{x, y};
            return;
        }
        grid[x][y] = cost;
        for (int i = 0; i < dire.length; i++) {
            int[] cur = values[i];
            if (master.canMove(dire[i]) && grid[cur[0] + x][cur[1] + y] == 0) {
                dfs(master, x + cur[0], y + cur[1], master.move(dire[i]));
                master.move(reDire[i]);
            }
        }
    }

    static class GridMaster {
        boolean canMove(char direction) {
            return true;
        }

        int move(char direction) {
            return 0;
        }

        boolean isTarget() {
            return true;
        }
    }
}
