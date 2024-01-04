package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 22:01
 */
public class LeetCode132 {

    public int minCut(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPal[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j - 1]);
            }
        }

        //令dp[i]表示从0到i的字符串可被拆分为最少的回文数的个数
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isPal[j][i]) {
                    if (j == 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1] - 1;
    }
}
