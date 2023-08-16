package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/12 18:35
 */
public class LeetCode2577 {

    int[][] result;
    int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumTime(int[][] grid) {
        if (!((grid.length == 1 || grid[1][0] - grid[0][0] <= 1) || (grid[0].length == 1 || grid[0][1] - grid[0][0] <= 1))) {
            return -1;
        }
        result = new int[grid.length][grid[0].length];
        for (int[] ints : result) {
            Arrays.fill(ints, -1);
        }
        result[0][0] = 0;
        Queue<Position> queue = new PriorityQueue<>(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return result[o1.x][o1.y] - result[o2.x][o2.y];
            }
        });
        queue.add(new Position(0, 0));
        while (!queue.isEmpty()) {
            Position p = queue.poll();
            int row = p.x, col = p.y;
            for (int[] e : direction) {
                int newrow = row + e[0], newcol = col + e[1];
                if (newrow >= 0 && newrow < result.length && newcol >= 0 && newcol < result[0].length) {
                    int tmp = Integer.MAX_VALUE;
                    if (grid[newrow][newcol] - result[row][col] <= 1) {
                        tmp = result[row][col] + 1;
                    } else if ((grid[newrow][newcol] - result[row][col]) % 2 == 1) {
                        tmp = grid[newrow][newcol];
                    } else {
                        tmp = grid[newrow][newcol] + 1;
                    }
                    if (result[newrow][newcol] < 0) {
                        result[newrow][newcol] = tmp;
                        queue.add(new Position(newrow, newcol));
                    } else {
                        result[newrow][newcol] = Math.min(result[newrow][newcol], tmp);
                    }

                }
            }
        }
        return result[grid.length - 1][grid[0].length - 1];
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
