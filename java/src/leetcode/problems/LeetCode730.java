package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 14:22
 */
public class LeetCode730 {

    int MOD = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] dp = new int[n][n];
        int[] L = new int[4], R = new int[4];
        Arrays.fill(L, -1);
        for (int i = n - 1; i >= 0; i--) {
            L[cs[i] - 'a'] = i;
            Arrays.fill(R, -1);
            for (int j = i; j < n; j++) {
                R[cs[j] - 'a'] = j;
                for (int k = 0; k < 4; k++) {
                    if (L[k] == -1 || R[k] == -1) continue;
                    int l = L[k], r = R[k];
                    if (l == r) {
                        dp[i][j] = (dp[i][j] + 1) % MOD;
                    } else if (l == r - 1) {
                        dp[i][j] = (dp[i][j] + 2) % MOD;
                    } else {
                        dp[i][j] = (dp[i][j] + dp[l + 1][r - 1] + 2) % MOD;
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
