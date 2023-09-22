package leetcode.problems;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 21:21
 */
public class LeetCode279 {

    public int numSquares(int n) {
        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int t = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                t = Math.min(t, dp[i - j * j] + 1);
            }
            dp[i] = t;
        }
        return dp[n];
    }
}

