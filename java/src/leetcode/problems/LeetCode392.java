package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:07
 */
public class LeetCode392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && s.charAt(i) == c) i++;
        }
        return i == s.length();
    }

    public boolean isSubsequence_dp(String s, String t) {
        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = true;
        }
        //s的前i个字符 是否是 t的前j个字符的子序列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
