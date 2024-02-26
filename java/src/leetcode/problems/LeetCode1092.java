package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 16:30
 */
public class LeetCode1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = m, j = n; i > 0 || j > 0; ) {
            if (i == 0 || (j != 0 && dp[i][j] == dp[i][j - 1])) {
                sb.append(str2.charAt(--j));
                continue;
            }
            if (j == 0 || dp[i][j] == dp[i - 1][j]) {
                sb.append(str1.charAt(--i));
                continue;
            }
            sb.append(str1.charAt(--i));
            j--;
        }
        return sb.reverse().toString();
    }
}
