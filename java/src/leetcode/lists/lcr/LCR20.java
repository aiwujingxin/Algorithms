package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 14:51
 */
public class LCR20 {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            cnt++;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
