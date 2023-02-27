package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/12 16:15
 * <a href="https://leetcode.cn/problems/largest-1-bordered-square/solution/java-dong-tai-gui-hua-by-resolmi/">...</a>
 */
public class LeetCode1139 {
    // 前缀和
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j][0]: i,j左边连续的1的个数
        //dp[i][j][1]: i,j上边连续的1的个数
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = 1 + dp[i][j - 1][0];
                    dp[i][j][1] = 1 + dp[i - 1][j][1];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //最短的那条边不一定是合法的边长，如果该边长不合法就需要缩减边长，直到找到合法的
                for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--) {
                    if (dp[i][j - side + 1][1] >= side && dp[i - side + 1][j][0] >= side) {
                        res = Math.max(res, side);
                        break; //更短的就没必要考虑了
                    }
                }
            }
        }
        System.out.println();
        return res * res;
    }
}
