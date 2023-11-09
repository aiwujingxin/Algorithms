package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 16:29
 * @see LeetCode313
 */
public class LeetCode264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[i2] * 2, num3 = dp[i3] * 3, num5 = dp[i5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                i2++;
            }
            if (dp[i] == num3) {
                i3++;
            }
            if (dp[i] == num5) {
                i5++;
            }
        }
        return dp[n];
    }
}
