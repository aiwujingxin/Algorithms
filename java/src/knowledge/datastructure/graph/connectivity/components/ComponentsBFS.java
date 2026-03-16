package knowledge.datastructure.graph.connectivity.components;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 3/17/26 02:09
 */
public class ComponentsBFS {

    // 定义上下左右四个方向的偏移量，方便在网格中移动
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 计算二维网格中的连通块（岛屿）数量
     *
     * @param grid 二维网格，'1'代表节点（陆地），'0'代表空白（水）
     * @return 连通块的数量
     */
    public int countComponents(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++; // 连通块计数加 1
                    bfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] visited, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];
            for (int[] dir : DIRECTIONS) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < rows &&
                        nextCol >= 0 && nextCol < cols &&
                        grid[nextRow][nextCol] == '1' &&
                        !visited[nextRow][nextCol]) {
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
