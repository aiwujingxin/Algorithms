package leetcode.lists.LCP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/9 01:24
 */
public class LCP56_dij {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int m = matrix.length, n = matrix[0].length();
        int[][] counts = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(counts[i], Integer.MAX_VALUE);
        }
        counts[start[0]][start[1]] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0], col = cell[1], count = cell[2];
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                int newRow = row + dir[0], newCol = col + dir[1];
                int newCount = count + (getIndex(matrix[row].charAt(col)) == i ? 0 : 1);
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && counts[newRow][newCol] > newCount) {
                    counts[newRow][newCol] = newCount;
                    pq.offer(new int[]{newRow, newCol, newCount});
                }
            }
        }
        return counts[end[0]][end[1]];
    }

    public int getIndex(char c) {
        return switch (c) {
            case '^' -> 0;
            case 'v' -> 1;
            case '<' -> 2;
            case '>' -> 3;
            default -> -1;
        };
    }
}

