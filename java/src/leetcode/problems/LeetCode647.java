package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:49
 */
public class LeetCode647 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
