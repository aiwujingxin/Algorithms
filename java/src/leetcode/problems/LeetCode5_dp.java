package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 14:52
 */
public class LeetCode5_dp {

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int begin = 0;
        int maxLen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            begin = i;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
