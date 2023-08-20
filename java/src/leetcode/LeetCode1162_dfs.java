package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 23:00
 */
public class LeetCode1162_dfs {


    //https://leetcode.com/problems/as-far-from-land-as-possible/discuss/1812102/Easy-to-understand-or-Java-or-DFS-or-BFS
    int count = 0;
    int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public int maxDistance(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];
        Set<Pair> lands = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    lands.add(new Pair(i, j));
                    q.add(new Pair(i, j));
                    grid[i][j] = 0;
                } else {
                    dp[i][j] = M + N;
                    grid[i][j] = -1;
                }
            }
        }

        // all water or land cells
        if (lands.size() == 0 || lands.size() == M * N) {
            return -1;
        }


        //dfs
        for (Pair land : lands) {
            dfsHelper(land.x, land.y, dp, M, N, -1);
        }
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }


        return max;
    }

    //dfs
    private void dfsHelper(int sr, int sc, int[][] dp, int row, int col, int dist) {
        if (dp[sr][sc] > 0 && dp[sr][sc] <= dist + 1) { //if already minimum distance present dont update
            return;
        }

        dp[sr][sc] = Math.min(dp[sr][sc], dist + 1);          //if new distance is minimum then update the distance

        for (int[] dir : dirs) {              //traverse in all four directions
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];
            if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || dp[newRow][newCol] == 0) {
                continue;
            }

            dfsHelper(newRow, newCol, dp, row, col, dist + 1);
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
