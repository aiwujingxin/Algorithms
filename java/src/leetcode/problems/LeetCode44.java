package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 14:58
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // init s 空串的情况
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    /* 等价于
                    for (int k = 0; k <= i; k++) {
                        if (dp[k][j - 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                    dp[i][j]  =  dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1] || dp[i][j-1]
                    dp[i-1][j]=  dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1]
                    dp[i][j]  =  dp[i-1][j] || dp[i][j-1]
                    */
                }
            }
        }
        return dp[m][n];
    }
}
