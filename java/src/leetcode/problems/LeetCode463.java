package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 11:04
 */
public class LeetCode463 {

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean needCheckTop = true;
                boolean needCheckDown = true;
                boolean needCheckLeft = true;
                boolean needCheckRight = true;
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        needCheckTop = false;
                    }
                    if (i == m - 1) {
                        needCheckDown = false;
                    }
                    if (j == 0) {
                        needCheckLeft = false;
                    }
                    if (j == n - 1) {
                        needCheckRight = false;
                    }
                    int t = 4;
                    if (needCheckLeft && grid[i][j - 1] == 1) {
                        t--;
                    }
                    if (needCheckRight && grid[i][j + 1] == 1) {
                        t--;
                    }
                    if (needCheckTop && grid[i - 1][j] == 1) {
                        t--;
                    }
                    if (needCheckDown && grid[i + 1][j] == 1) {
                        t--;
                    }
                    res += t;
                }
            }
        }
        return res;
    }
}
