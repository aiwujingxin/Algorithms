package leetcode.problems;

import java.util.ArrayDeque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/4/25 21:07
 */
public class LeetCode1263_opt {
    private final int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private char[][] grid;
    private int m;
    private int n;

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        int[] target = new int[2];
        int[] person = new int[2];
        int[] box = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;
                } else if (grid[i][j] == 'B') {
                    box[0] = i;
                    box[1] = j;
                } else if (grid[i][j] == 'S') {
                    person[0] = i;
                    person[1] = j;
                }
            }
        }

        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][][] isVisited = new boolean[m][n][4];
        for (int i = 0; i < 4; i++) {
            // person move from person2[] to person[]
            int personI = directions[i][0] + target[0];
            int personJ = directions[i][1] + target[1];
            int personI2 = 2 * directions[i][0] + target[0];
            int personJ2 = 2 * directions[i][1] + target[1];
            if (personI >= 0 && personJ >= 0 && personI < m && personJ < n && grid[personI][personJ] != '#'
                    && personI2 >= 0 && personJ2 >= 0 && personI2 < m && personJ2 < n && grid[personI2][personJ2] != '#') {
                deque.add(new int[]{target[0], target[1], i, 0});
                isVisited[target[0]][target[1]][i] = true;
            }
        }

        while (deque.size() > 0) {
            int[] curr = deque.pollFirst();
            int boxI = directions[curr[2]][0] + curr[0];
            int boxJ = directions[curr[2]][1] + curr[1];
            int person3I = 2 * directions[curr[2]][0] + curr[0];
            int person3J = 2 * directions[curr[2]][1] + curr[1];
            if (boxI == box[0] && boxJ == box[1] && canReach(new int[]{person3I, person3J}, person, box))
                return curr[3] + 1;

            for (int i = 0; i < 4; i++) {
                // person move from person2[] to person[]
                int personI = directions[i][0] + boxI;
                int personJ = directions[i][1] + boxJ;
                int personI2 = 2 * directions[i][0] + boxI;
                int personJ2 = 2 * directions[i][1] + boxJ;
                if (personI >= 0 && personJ >= 0 && personI < m && personJ < n && grid[personI][personJ] != '#'
                        && personI2 >= 0 && personJ2 >= 0 && personI2 < m && personJ2 < n && grid[personI2][personJ2] != '#'
                        && !isVisited[boxI][boxJ][i]
                        && canReach(new int[]{person3I, person3J}, new int[]{personI2, personJ2}, new int[]{boxI, boxJ})) {
                    deque.add(new int[]{boxI, boxJ, i, curr[3] + 1});
                    isVisited[boxI][boxJ][i] = true;
                }
            }
        }

        return -1;
    }

    private boolean canReach(int[] newPos, int[] currPos, int[] boxPos) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[m][n];
        deque.add(newPos);
        while (deque.size() > 0) {
            int[] curr = deque.pollFirst();
            if (currPos[0] == curr[0] && currPos[1] == curr[1]) return true;
            for (int[] d : directions) {
                int newI = curr[0] + d[0];
                int newJ = curr[1] + d[1];
                if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && !isVisited[newI][newJ] && grid[newI][newJ] != '#' && (newI != boxPos[0] || newJ != boxPos[1])) {
                    isVisited[newI][newJ] = true;
                    deque.add(new int[]{newI, newJ});
                }
            }
        }

        return false;
    }
}
