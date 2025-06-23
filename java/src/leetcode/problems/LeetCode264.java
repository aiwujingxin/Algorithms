package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 16:29
 */
public class LeetCode264 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = dp[i2] * 2, b = dp[i3] * 3, c = dp[i5] * 5;
            dp[i] = Math.min(a, Math.min(b, c));
            if (dp[i] == a) i2++;
            if (dp[i] == b) i3++;
            if (dp[i] == c) i5++;
        }
        return dp[n];
    }
}
