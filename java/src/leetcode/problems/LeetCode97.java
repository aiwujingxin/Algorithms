package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/21 13:23
 */
public class LeetCode97 {

    //https://leetcode.cn/problems/interleaving-string/solutions/335561/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (s3.length() != m + n) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= n && s2.charAt(j - 1) == s3.charAt(j - 1); j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int index = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s3.charAt(index) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(index) == s2.charAt(j - 1));
            }
        }
        return dp[m][n];
    }
}
