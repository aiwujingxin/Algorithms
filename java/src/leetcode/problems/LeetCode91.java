package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 13:24
 * @description dp[i] 由 dp[i-1]（单字有效）和 dp[i-2]（双字有效）累加而成。
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
