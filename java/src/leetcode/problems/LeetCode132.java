package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 22:01
 */
public class LeetCode132 {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
            }
        }

        //令dp[i]表示从0到i的字符串可被拆分为最少的回文数的个数
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    if (j == 0) {
                        f[i] = 1;
                    } else {
                        f[i] = Math.min(f[i], f[j - 1] + 1);
                    }
                }
            }
        }
        return f[n - 1] - 1;
    }
}
