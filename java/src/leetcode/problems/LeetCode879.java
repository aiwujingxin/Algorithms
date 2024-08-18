package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/13 18:58
 * @description 动态规划取正数
 * @see 1020.cpp
 */
public class LeetCode879 {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;
        int MOD = (int) 1e9 + 7;
        int[][][] dp = new int[m + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i - 1]) {
                        dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])]) % MOD;
                    }
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= n; j++) {
            sum = (sum + dp[m][j][minProfit]) % MOD;
        }
        return sum;
    }
}
