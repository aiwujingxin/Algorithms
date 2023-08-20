package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 15:03
 */
public class LeetCode1062_dp {

    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        //dp[i][j] 表示s的下标i 和 j 作为结尾两者最长相等子串长度
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(0) == s.charAt(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    //动态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}
