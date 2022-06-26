package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 16:55
 */
public class LeetCode827_v1 {

    //https://leetcode.com/problems/making-a-large-island/discuss/1377835/Java-DFS-Connected-Components-Solution-or-Union-Find-Solution
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Map<Integer, Integer> component = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int n = grid.length, ans = 0, color = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                paint(grid, i, j, color);
                if (component.containsKey(color)) {
                    ans = Math.max(ans, component.get(color));
                }
                color++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }

                Set<Integer> neigh = new HashSet<>();
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 0) {
                        continue;
                    }
                    neigh.add(grid[x][y]);
                }

                int size = 1;
                for (int s : neigh) {
                    size += component.get(s);

                }
                ans = Math.max(ans, size);
            }
        }
        return ans;
    }

    void paint(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = color;
        component.put(color, component.getOrDefault(color, 0) + 1);
        for (int[] dir : dirs) {
            paint(grid, i + dir[0], j + dir[1], color);
        }
    }
}
