package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/8/18 18:13
 */
public class LeetCode879_v1 {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][] dp = new long[n + 1][minProfit + 1];
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            for (int j = n; j >= 0; j--) {
                if (j + group[i] > n) {
                    continue;
                }
                for (int k = minProfit; k >= 0; k--) {
                    dp[j + group[i]][Math.min(minProfit, k + profit[i])] = (dp[j + group[i]][Math.min(minProfit, k + profit[i])] + dp[j][k]) % 1000000007;
                }
            }
        }
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result = (result + dp[i][minProfit]) % 1000000007;
        }
        return (int) result;
    }
}
