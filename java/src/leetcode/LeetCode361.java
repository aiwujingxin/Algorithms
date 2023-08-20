package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/20 10:15
 */
public class LeetCode361 {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        int[][] dp = new int[m][n]; // 表示炸弹放在m, n能炸死最多敌人的数量

        int[] up = new int[n];
        //sweep from the top-left to bottom-right
        for (int i = 0; i < m; i++) {
            int left = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    dp[i][j] += up[j] + left;
                } else if (grid[i][j] == 'W') { // 墙
                    up[j] = 0;
                    left = 0;
                } else if (grid[i][j] == 'E') {
                    up[j]++;
                    left++;
                }
            }
        }

        System.out.println(Arrays.toString(up));
        int[] down = new int[n];
        //sweep from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            int right = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == '0') {
                    dp[i][j] += down[j] + right;
                    res = Math.max(res, dp[i][j]);
                } else if (grid[i][j] == 'W') {
                    down[j] = 0;
                    right = 0;
                } else {
                    down[j]++;
                    right++;
                }
            }
        }
        return res;
    }
}
