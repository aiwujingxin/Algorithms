package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 17:30
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
