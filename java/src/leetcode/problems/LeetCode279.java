package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 00:28
 */
public class LeetCode279 {

    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
