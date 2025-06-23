package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 6/23/25 00:50
 * @description dp[i]表示前i个字符的解码方案数; 分类讨论
 * @see LeetCode91
 */
public class LeetCode639 {

    int MOD = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = ways1(s.charAt(0));
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 2), c2 = s.charAt(i - 1);
            dp[i] = (ways1(c2) * dp[i - 1] + ways2(c1, c2) * dp[i - 2]) % MOD;
        }
        return (int) dp[n];
    }

    private int ways1(char c) {
        if (c == '*') return 9;
        return c == '0' ? 0 : 1;
    }

    private int ways2(char c1, char c2) {
        if (c1 == '*' && c2 == '*') return 15;
        if (c1 == '*') return c2 <= '6' ? 2 : 1;
        if (c2 == '*') {
            if (c1 == '1') return 9;
            if (c1 == '2') return 6;
            return 0;
        }
        int val = (c1 - '0') * 10 + (c2 - '0');
        return val >= 10 && val <= 26 ? 1 : 0;
    }
}
