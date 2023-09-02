package leetcode;

import basic.datastructure.advance.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 21:24
 */
public class LeetCode200_uf {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int count0 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int newX = i + dir[0];
                        int newY = j + dir[1];
                        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] == '0') {
                            continue;
                        }
                        uf.union(i * n + j, newX * n + newY);
                    }
                } else {
                    count0++;
                }
            }
        }
        return uf.getCount() - count0;
    }
}
