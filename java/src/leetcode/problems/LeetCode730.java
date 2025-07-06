package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 14:22
 */
public class LeetCode730 {

    public int countPalindromicSubsequences(String str) {
        int n = str.length();
        int MOD = 1000000007;
        char[] s = str.toCharArray();
        long[][] dp = new long[n][n];
        int[] last = new int[256];
        int[] left = new int[n];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            left[i] = last[s[i]];
            last[s[i]] = i;
        }
        int[] right = new int[n];
        Arrays.fill(last, n);
        for (int i = n - 1; i >= 0; i--) {
            right[i] = last[s[i]];
            last[s[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2, l, r; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s[i] != s[j]) {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + MOD) % MOD;
                } else {
                    l = right[i];
                    r = left[j];
                    if (l > r) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 2) % MOD;
                    } else if (l == r) {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 1) % MOD;
                    } else {
                        dp[i][j] = (dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1] + MOD) % MOD;
                    }
                }
            }
        }
        return (int) dp[0][n - 1];
    }
}
