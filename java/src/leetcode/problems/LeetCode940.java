package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 20:09
 */
public class LeetCode940 {

    int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        int n = s.length();
        int ans = 0;
        int[][] dp = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            for (int c = 0; c < 26; c++) {
                if (s.charAt(i - 1) - 'a' != c) {
                    dp[i][c] = dp[i - 1][c];
                } else {
                    int sum = 1;
                    for (int k = 0; k < 26; k++) {
                        sum = (sum + dp[i - 1][k]) % MOD;
                    }
                    dp[i][c] = sum;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            ans = (ans + dp[n][i]) % MOD;
        }
        return ans;
    }
}
