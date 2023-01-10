package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/28 23:27
 */
public class Offer14_1_dfs {

    //记忆化递归
    public int cuttingRope(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],
                        Math.max(j * (i - j), Math.max(dp[j] * (i - j), Math.max(j * dp[i - j], dp[j] * dp[i - j]))));
            }

        }
        return dp[n];
    }
}
