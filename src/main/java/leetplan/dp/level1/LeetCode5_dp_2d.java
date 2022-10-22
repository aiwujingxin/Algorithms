package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 10:27
 */
public class LeetCode5_dp_2d {

    //https://leetcode.com/problems/longest-palindromic-substring/discuss/2156691/Simple-DP-Solution-or-JAVA-Explained

    public String longestPalindrome(String s) {
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = s.charAt(i) == s.charAt(i + len) && (len < 2 || dp[i + 1][i + len - 1]);
                if (dp[i][i + len] && len > end - start) {
                    start = i;
                    end = i + len;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
