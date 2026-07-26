package knowledge.algorithms.search.dfs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description Flood Fill 与迭代式 DFS (网格搜索)
 * <适用场景>
 * 网格连通块问题：岛屿数量/面积、图像渲染、被围绕的区域。既可递归也可显式栈迭代（防爆栈）。
 * <核心>
 * 从起点出发向四邻方向扩散，把可达且同色的格子染成新色/标记访问，一次 fill 覆盖一个连通块。
 * @see leetcode.problems.LeetCode200 岛屿数量
 * @see leetcode.problems.LeetCode695 岛屿的最大面积
 * @see leetcode.problems.LeetCode733 图像渲染
 * @see IDDFS 迭代加深
 */
public class FloodFill {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 递归 Flood Fill：统计岛屿数量（'1' 为陆地，'0' 为水）。
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1')
            return;
        grid[r][c] = '0'; // 标记已访问，避免重复
        for (int[] d : DIRS)
            dfs(grid, r + d[0], c + d[1]);
    }

    /**
     * 迭代式 Flood Fill：显式栈避免深度过大爆栈，返回起点所在连通块的面积。
     */
    public static int areaIterative(int[][] grid, int sr, int sc) {
        int color = grid[sr][sc];
        int area = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{sr, sc});
        grid[sr][sc] = -1; // 入栈即标记
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            area++;
            for (int[] d : DIRS) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                        && grid[nr][nc] == color) {
                    grid[nr][nc] = -1;
                    stack.push(new int[]{nr, nc});
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0'},
                {'1', '0', '0', '1'},
                {'0', '0', '1', '1'}
        };
        System.out.println("numIslands expect 2: " + numIslands(grid));
        int[][] g2 = {{1, 1, 0}, {1, 0, 0}, {0, 0, 1}};
        System.out.println("areaIterative(0,0) expect 3: " + areaIterative(g2, 0, 0));
    }
}
