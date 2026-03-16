package knowledge.datastructure.graph.connectivity.components;

import knowledge.datastructure.adv.UnionFind;

/**
 * @author wujingxinit@outlook.com
 * @date 3/17/26 02:11
 */
public class ComponentsUF {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        int waterCount = 0; // 记录水域的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    waterCount++; // 统计水域
                } else {
                    int curr = i * cols + j;
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        uf.union(curr, i * cols + (j + 1));
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        uf.union(curr, (i + 1) * cols + j);
                    }
                }
            }
        }
        return uf.getCount() - waterCount;
    }
}
